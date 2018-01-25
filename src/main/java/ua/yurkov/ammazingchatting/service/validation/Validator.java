package ua.yurkov.ammazingchatting.service.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Validator<T> {

    protected List<ValidationRule<T>> validationRules;

    public Validator() {
        validationRules = new ArrayList<>();
    }

    protected abstract void validateRules(T objectToValidate, Map<String, String> errors);

    protected abstract String getEntityName();

    public Validator<T> addRule(ValidationRule<T> rule) {
        validationRules.add(rule);
        return this;
    }

    public void validate(T objectToValidate) {
        Map<String, String> errors = new HashMap<>();

        throwExceptionIfNull(objectToValidate, errors, "target object");
        validateRules(objectToValidate, errors);

        throwExceptionIfNeed(getEntityName(), errors);
    }

    private void addErrorIfNull(Object targetObject, Map<String, String> errors, String field) {
        if (Objects.isNull(targetObject)) {
            errors.put(field, "can not be null");
        }
    }

    private void throwExceptionIfNeed(String entityName, Map<String, String> errors) {
        if (!errors.isEmpty()) {
            throw new ValidationException(entityName, errors);
        }
    }

    private void throwExceptionIfNull(Object targetObject, Map<String, String> errors, String entityName) {
        addErrorIfNull(targetObject, errors, entityName);
        throwExceptionIfNeed(entityName, errors);
    }
}
