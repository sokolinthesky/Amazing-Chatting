package ua.yurkov.ammazingchatting.service.validation;

import javax.annotation.PostConstruct;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
public abstract class ValidatorInitializer {

    @PostConstruct
    public void init() {
        initializeSpecificValidator();
    }

    protected abstract void initializeSpecificValidator();
}
