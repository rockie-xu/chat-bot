package dev.rockie.telegrambot.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateHandler implements Handler<Update> {

    private static final Logger LOG = LogManager.getLogger(UpdateHandler.class);

    private final MessageHandler messageHandler = new MessageHandler();
    private final CallbackHandler callbackHandler = new CallbackHandler();

    @Override
    public void handle(Update update) {
        try {
            handleUpdate(update);
        } catch (Exception e) {
            LOG.error("Error update handling", e);
        }
    }

    private void handleUpdate(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText() && message.getReplyMarkup() == null) {
                 messageHandler.handle(message);
            }
        } else if (update.hasCallbackQuery()) {
            callbackHandler.handle(update.getCallbackQuery());
        }
    }
}
