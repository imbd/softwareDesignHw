package chat.model.network;

import chat.model.Controller;
import chat.model.network.protocol.P2PMessenger;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * Created by the7winds on 03.12.16.
 */
public class TextMessageHandler implements Handler {

    private final Controller controller;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public TextMessageHandler(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void handle(P2PMessenger.Message message) {
        logger.info("handle");
        P2PMessenger.TextMessage textMessage = message.getTextMessage();
        SwingUtilities.invokeLater(() -> controller.getAppFrame()
                .addMessage(controller.getCompanion(), textMessage.getDate(), textMessage.getText()));
    }
}
