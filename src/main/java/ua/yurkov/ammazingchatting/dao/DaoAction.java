package ua.yurkov.ammazingchatting.dao;

/**
 * Created by yevhenii on 30.08.17.
 */
@FunctionalInterface
public interface DaoAction<T> {
    T execute();
}
