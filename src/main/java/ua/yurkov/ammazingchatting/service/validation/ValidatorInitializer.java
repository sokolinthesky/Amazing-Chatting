package ua.yurkov.ammazingchatting.service.validation;


/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
public abstract class ValidatorInitializer {

    public ValidatorInitializer() {
        init();
    }

    /**
     * There is no way to use @PostConstruct in JDK9, therefore we need to do it in constructor.
     */
    //@PostConstruct
    public void init() {
        initializeSpecificValidator();
    }

    protected abstract void initializeSpecificValidator();
}
