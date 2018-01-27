package ua.yurkov.ammazingchatting.web.error;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
public class ExceptionValue<T> {
    private int status;
    private T description;

    public ExceptionValue(int status, T description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getDescription() {
        return description;
    }

    public void setDescription(T description) {
        this.description = description;
    }
}
