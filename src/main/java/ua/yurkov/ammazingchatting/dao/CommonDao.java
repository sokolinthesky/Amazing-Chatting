package ua.yurkov.ammazingchatting.dao;

import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class CommonDao<T, I> {

    protected EntityManager entityManager;
    private Class<T> entityClass;

    public CommonDao(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @SuppressWarnings("unchecked")
    protected List<T> getAllEntitiesWithoutParameters(String hql) {
        return execute(() -> (List<T>) entityManager.createQuery(hql).getResultList());
    }

    @SuppressWarnings("unchecked")
    protected Optional<T> getSingleEntityByParameters(String hql, Map<String, String> parameters) {
        return getOrEmpty(() -> {
            Query query = entityManager.createQuery(hql);
            query.setMaxResults(1);
            setParameters(query, parameters);

            List<T> singleEntityList = (List<T>)query.getResultList();
            if (singleEntityList.isEmpty()) {
                return null;
            }

            return singleEntityList.get(0);
        });
    }

    protected Optional<T> getEntityById(I id) {
        return getOrEmpty(() -> entityManager.find(entityClass, id));
    }

    protected Optional<T> getOrEmpty(DaoAction<T> daoAction) {
        return execute(() -> {
            T entity = daoAction.execute();
            return Optional.ofNullable(entity);
        });
    }

    protected void createEntity(T entity) {
        execute(() -> {
            entityManager.persist(entity);
            return null;
        });
    }

    protected <E> E execute(Supplier<E> supplier) {
        try {
            return supplier.get();
        } catch (PersistenceException e) {
            throw new DaoException("Error has happened in the processing of the entity operation execution.", e);
        }
    }

    public abstract Logger getLogger();

    private void setParameters(Query query, Map<String, String> parameters) {
        parameters.forEach(query::setParameter);
    }
}
