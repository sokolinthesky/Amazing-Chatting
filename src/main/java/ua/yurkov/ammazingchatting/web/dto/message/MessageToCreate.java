package ua.yurkov.ammazingchatting.web.dto.message;

import java.util.UUID;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
public class MessageToCreate {

    private UUID id;
    private String message;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageToCreate{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
