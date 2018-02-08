package ua.yurkov.ammazingchatting.dao.message;

import org.springframework.stereotype.Repository;
import ua.yurkov.ammazingchatting.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO: Change class description
 *
 * @author yevhenii.yurkov (yyurkov)
 * @since 0.10.0
 */
@Repository
public class MessageDaoImpl implements MessageDao {

    private Map<UUID, Message> messagesMock = new ConcurrentHashMap<>();

    @Override
    public void saveMessage(final Message message) {
        messagesMock.put(message.getId(), message);
    }

    @Override
    public List<Message> getMessages() {
        return new ArrayList<>(messagesMock.values());
    }
}
