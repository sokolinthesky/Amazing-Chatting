package ua.yurkov.ammazingchatting.web.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.yurkov.ammazingchatting.model.Message;
import ua.yurkov.ammazingchatting.service.message.MessageService;
import ua.yurkov.ammazingchatting.web.dto.message.MessageToCreate;
import ua.yurkov.ammazingchatting.web.dto.message.MessageToView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: Change class description
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;
    private ModelMapper modelMapper;

    public MessageController(MessageService messageService, ModelMapper modelMapper) {
        this.messageService = messageService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<Void> sentMessage(@RequestBody MessageToCreate messageToCreate) {
        messageService.sentMessage(modelMapper.map(messageToCreate, Message.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<MessageToView>> getMessages() {
        List<Message> messages = messageService.getMessages();
        List<MessageToView> messagesToView =  messages.stream()
                                                      .map(message -> modelMapper.map(message, MessageToView.class))
                                                      .collect(Collectors.toList());

        return ResponseEntity.ok(messagesToView);
    }
}
