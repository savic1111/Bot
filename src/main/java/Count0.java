import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import javax.inject.Inject;


class Count0 {
master master = new master();
Text text = new Text();

    void Say(Message message) throws InterruptedException {

        for (int i = 0; i <= text.GREETING.length - 1; i++) {
            try {
                master.sendMessage(master.sendMessager(message,text.GREETING[i]));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            Thread.sleep(500);
        }

    }

    void SayName(Message message) throws InterruptedException {
        try {

            master.sendMessage(master.sendMessager(message,"Ну привет "+message.getText()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        Thread.sleep(500);
    }

    void SayCount(Message message) throws InterruptedException {
        SendMessage send = new SendMessage();
        //send = m.sendMessager(message);
        //send.setText("Ваш счет");

        try {

            master.sendMessage(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        Thread.sleep(500);
    }

}
