package ua.yurkov.ammazingchatting.service.validation;

import java.util.Map;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
public interface ValidationRule<T> {
    void verifyRuleFor(T objectToVerify, Map<String, String> errors);
}
