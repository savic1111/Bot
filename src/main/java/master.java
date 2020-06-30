
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.games.Game;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class master extends TelegramLongPollingBot {

    private static final String BotUserName = "testQWERT123456789_bot";
    private static final String token = "1133891649:AAETmVNnjaIZoln20eeG_ptTBJsJr2GqSeQ";
    Keyboards keyboards = new Keyboards();

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

    public SendMessage sendMessager(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(false);
        sendMessage.setChatId(message.getChatId().toString());

        return sendMessage;
    }




    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Model model = new Model();
        count0 = new Count0();
        if (message != null && message.hasText()) {
            switch (count) {
                case 0:
                    try {

                        count0.Say(message);
                        if(update.getMessage().getText().equals("Setting"))
                        {
                            keyboards.count++;
                            SendMessage send = new SendMessage();
                            send = sendMessager(message);
                            send.setText("Ваш счет" + keyboards.count);



                            try {
                                keyboards.setButtons(send);
                                sendMessage(send);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                            Thread.sleep(500);


                        }
                        System.out.println(keyboards.count);


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

    @Override
    public String getBotUsername() {
        return BotUserName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
