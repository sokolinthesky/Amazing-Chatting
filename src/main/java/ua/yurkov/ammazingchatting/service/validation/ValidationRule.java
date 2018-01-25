package ua.yurkov.ammazingchatting.service.validation;

import java.util.Map;

public interface ValidationRule<T> {
    void verifyRuleFor(T objectToVerify, Map<String, String> errors);
}
