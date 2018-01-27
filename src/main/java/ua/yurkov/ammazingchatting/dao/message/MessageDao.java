package ua.yurkov.ammazingchatting.dao.message;

import ua.yurkov.ammazingchatting.model.Message;

import java.util.List;
import java.util.UUID;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
public interface MessageDao {

    void saveMessage(Message message);

    List<Message> getMessages();
}
