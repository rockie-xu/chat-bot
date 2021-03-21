package dev.rockie.telegrambot.core;

import dev.rockie.telegrambot.handlers.UpdateHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

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
        updateHandler.handle(update);
    }

}
