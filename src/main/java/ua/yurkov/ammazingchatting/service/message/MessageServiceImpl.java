package ua.yurkov.ammazingchatting.service.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.yurkov.ammazingchatting.dao.message.MessageDao;
import ua.yurkov.ammazingchatting.model.Message;

import java.util.List;
import java.util.UUID;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    private MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    @Transactional
    public void sentMessage(Message message) {
        LOG.info("Message to sent: {}.", message);
        message.setId(UUID.randomUUID());
        messageDao.saveMessage(message);
    }

    @Override
    public List<Message> getMessages() {
        return messageDao.getMessages();
    }
}
