package ua.yurkov.ammazingchatting.service.message;

import ua.yurkov.ammazingchatting.model.Message;

import java.util.List;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
public interface MessageService {

    void sentMessage(Message message);

    List<Message> getMessages();
}
