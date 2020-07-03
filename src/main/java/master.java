import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class master extends TelegramLongPollingBot {

    private static final String BotUserName = "testQWERT123456789_bot";
    private static final String token = "1133891649:AAETmVNnjaIZoln20eeG_ptTBJsJr2GqSeQ";
    Keyboards keyboards = new Keyboards();
    TimerMessage timerMessage = new TimerMessage();

    Count0 count0;
    private int count = 0;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        try {
            new TelegramBotsApi().registerBot(new master());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public SendMessage sendMessager(Message message,String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(false);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        return sendMessage;
    }


    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        count0 = new Count0();
        if (message != null && message.hasText()) {
            switch (count) {
                case 0:
                    try {

                        timerMessage.counter(10,message);
                        count++;
                        if(update.getMessage().getText().equals("Setting"))
                        {
                            keyboards.count++;
                            SendMessage send = new SendMessage();
                            send = sendMessager(message,"Ваш счет" + keyboards.count);
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
