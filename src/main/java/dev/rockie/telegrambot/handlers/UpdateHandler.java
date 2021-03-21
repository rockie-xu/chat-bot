package dev.rockie.telegrambot.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateHandler implements Handler<Update> {

    private static final Logger LOG = LogManager.getLogger(UpdateHandler.class);

    @Override
    public void handle(Update update) {
        try {
            handleUpdate(update);
        } catch (Exception e) {
            LOG.error("Error update handling", e);
        }
    }

    private void handleUpdate(Update update) {

    }
}
