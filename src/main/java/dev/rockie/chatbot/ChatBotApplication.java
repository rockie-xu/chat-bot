package dev.rockie.chatbot;

import dev.rockie.chatbot.controller.ChatbotController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class ChatBotApplication {

    public static void main(String[] args) {

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new ChatbotController());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
