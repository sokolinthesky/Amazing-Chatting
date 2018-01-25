package ua.yurkov.ammazingchatting.dao.message;

import ua.yurkov.ammazingchatting.model.Message;

import java.util.List;
import java.util.UUID;

public interface MessageDao {

    void saveMessage(Message message);

    List<Message> getMessages();
}
