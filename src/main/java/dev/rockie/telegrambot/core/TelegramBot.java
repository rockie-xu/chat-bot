package dev.rockie.telegrambot.core;

import dev.rockie.telegrambot.handlers.UpdateHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {

    private static final ConfigReader CONFIG = ConfigReader.getInstance();
    public static final String TELEGRAM_BOT_USERNAME = CONFIG.get("telegram.bot.username");
    public static final String TELEGRAM_BOT_TOKEN = CONFIG.get("telegram.bot.token");

    private final UpdateHandler updateHandler = new UpdateHandler();

    @Override
    public String getBotUsername() {
        return TELEGRAM_BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return TELEGRAM_BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
//        updateHandler.handle(update);
        sendMsg(update, "step 1: set the date");
        sendMsg(update, java.time.LocalDate.now().toString());
    }

    private void sendMsg(Update update, String setText) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(setText);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
