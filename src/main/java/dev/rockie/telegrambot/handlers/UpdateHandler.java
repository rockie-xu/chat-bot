package dev.rockie.telegrambot.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

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

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        sendMessage.setChatId(message.getChatId().toString());

//        sendMessage.setReplyToMessageId(message.getMessageId());

        sendMessage.setText(text);
//        try {
//
//            setButtons(sendMessage);
//            execute(sendMessage);
//
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

    private void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/setting"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

    }

    private void handleUpdate(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText() && message.getReplyMarkup() == null) {
                if (update.getMessage().getText().equals("/start")) {
//                    sendMsg(message, "Text to test");
                    messageHandler.handle(message);
                } else {

                }
            }
        } else if (update.hasCallbackQuery()) {
            callbackHandler.handle(update.getCallbackQuery());
//
//            // Set variables
//            String call_data = update.getCallbackQuery().getData();
//            long message_id = update.getCallbackQuery().getMessage().getMessageId();
//            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
//
//            if (call_data.equals("update_msg_text")) {
//                String answer = "Updated message text";
//                EditMessageText new_message = new EditMessageText();
//
//                new_message.setChatId(chatId);
//                new_message.setMessageId(toIntExact(message_id));
//                new_message.setText(answer);
//
//                try {
//                    execute(new_message);
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
