package ua.yurkov.ammazingchatting.web.endpoint.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Web socket endpoint for user message receiving.
 *
 * @author yevhenii yurkov
 * @since 0.1.0
 */
@Controller
public class MessageWebSocketEndpoint {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/greetings")
    public String sendMessage(String message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(message);
        return message;
    }
}
