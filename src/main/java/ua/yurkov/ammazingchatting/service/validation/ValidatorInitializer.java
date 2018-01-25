package ua.yurkov.ammazingchatting.service.validation;

import javax.annotation.PostConstruct;

public abstract class ValidatorInitializer {

    @PostConstruct
    public void init() {
        initializeSpecificValidator();
    }

    protected abstract void initializeSpecificValidator();
}
