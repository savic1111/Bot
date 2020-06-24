
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class master extends TelegramLongPollingBot {

    Count0 count0;
    private int count = 0;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {

            telegramBotsApi.registerBot(new master());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }


    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("Help"));
        keyboardFirstRow.add(new KeyboardButton("Setting"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }


    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        count0 = new Count0();
        if (message != null && message.hasText()) {
            switch (count) {
                case 0:
                    try {
                        count0.Say(message);
                        count++;
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                case 1:
                    try {
                        count0.SayName(message);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }

        }
    }


    public String getBotUsername() {
        return "testQWERT123456789_bot";
    }

    public String getBotToken() {
        return "1133891649:AAETmVNnjaIZoln20eeG_ptTBJsJr2GqSeQ";
    }
}
