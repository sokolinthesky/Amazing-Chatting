package ua.yurkov.ammazingchatting.service.message;

import ua.yurkov.ammazingchatting.model.Message;

import java.util.List;

public interface MessageService {

    void sentMessage(Message message);

    List<Message> getMessages();
}
