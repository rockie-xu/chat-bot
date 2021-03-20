package dev.rockie.chatbot.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class ChatbotController extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "LearnCapitals_Bot";
    }

    @Override
    public String getBotToken() {
        return "1415091710:AAGmDVovYj6qALClG54DMkSkSxIu9-chEHw";
//        return null;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {

            if (update.getMessage().getText().equals("/start")) {
                SendMessage message = new SendMessage();

                message.setChatId(update.getMessage().getChatId().toString());
                message.setText(update.getMessage().getText());

                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();

                InlineKeyboardButton btn = new InlineKeyboardButton();
                btn.setText("Update message text");
                btn.setCallbackData("update_msg_text");

                rowInline.add(btn);

                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }
        } else if(update.hasCallbackQuery()) {}
    }

}
