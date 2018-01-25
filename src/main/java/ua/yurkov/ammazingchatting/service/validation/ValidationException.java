package ua.yurkov.ammazingchatting.service.validation;

import java.util.Map;

public class ValidationException extends RuntimeException {

    private static final String MESSAGE = "%s is not valid. List of not valid fields: %s.";

    private Map<String, String> errors;
    private String entityName;

    public ValidationException(String entityName, Map<String, String> errors) {
        this.entityName = entityName;
        this.errors = errors;
    }

    public String getDescription() {
        return String.format(MESSAGE, entityName, errors);
    }
}
