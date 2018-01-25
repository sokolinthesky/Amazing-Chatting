package ua.yurkov.ammazingchatting.service.message;

import ua.yurkov.ammazingchatting.model.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {

    void sentMessage(Message message);

    List<Message> getMessages();
}
