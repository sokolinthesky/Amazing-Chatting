/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package ua.yurkov.ammazingchatting.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.UUID;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov (
 * @since 0.1.0
 */
//@Entity
public class Message {

    @Id
    private UUID id;

    private String message;

    public Message() {}

    public Message(UUID id, String message) {
        this.id = id;
        this.message = message;
    }

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Message message1 = (Message) o;

        if (!id.equals(message1.id)) {
            return false;
        }
        return message.equals(message1.message);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
