import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMessage {
    int timer;
    public void counter(int counter, final Message message) {
        timer = counter;
        final Timer timerA = new Timer();
        final TimerTask timerTask = new TimerTask() {
            master master = new master();

            @Override
            public void run() {
                if (timer >= 0) {
                    try {
                        String timerText = String.valueOf(timer);
                        master.sendMessage(master.sendMessager(message, timerText));
                        timer--;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (timer == 0) {
                    try {
                        master.sendMessage(master.sendMessager(message, "Время вышло,нахер!!!"));
                    }catch (TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                    timerA.cancel();
                }
            }
        };
        timerA.schedule(timerTask, 0, 1000);
    }
}
