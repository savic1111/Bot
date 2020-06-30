import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.exceptions.TelegramApiException;


class Count0 {




    public String[] GREETING =
            {
                    "Город:Либерти-Сити",
                    "Адрес:Сэмпл-гринадер,23",
                    "Время: 03:33 AM",
                    "Он сказал, что дверь будет открыта. И она действительно открыта.",
                    "Квартира находится в самом криминальном доме Либерти-сити и ты после этого факта не закрываешь дверь?",
                    "Мне он объяснил довольно просто, сверху - бордель, снизу-картель, а по соседству - детский дом, честно говоря, я не хочу знать, что там происходит.\n" +
                            "Он только недавно успел заехать, это дает ему возможность проворачитвать еще более темные дела, а полицейские будут стучаться в старые квартиры.\n" +
                            "Я даже не уверен, знает ли кто-то, что он вообще сюда заехал. Открытая на распашку дверь лишь только подкрепляла увренность в невинности.",
                    "Настойщий преступник закроется на 50 замков, будь у него такая возможность. Но этот человек не такой.\n" +
                            "Квартира пахла едой, этот запах настолько плотный, что я сразу почувствовал невыносимую духоту, но нет,я не уйду, как в прошлый раз.\n" +
                            "Бетонный пол лишь говорил о практичности этого человека, а расписные обои о его человечности. Кроме тапочек, я больше и не смог ничего подметить. Абсолютно пустой коридор.\n" +
                            "Я стоял в коридоре с нежеланием совершать лишние движения, по моим подсчетам квартира трехкомнатная, двери в каждую комнату были закрыты, жуткая тишина царила в них.\n" +
                            "Мгновенная мысль - там трупы, следующая мысль - моя се... Кто-то громко шмыгнул носом в комнате напротив меня. Мое состояние стало тревожным, я еще больше не захотел шевелиться.\n" +
                            "А если они услышат меня? Как они отреагируют? Я не знаю, что это за люди и эта неизвестность лишь разваивает мою тревогу. Я знаю только одно, я еще могу свалить!!",
                    "Отдаленно слышу чью-то ходьбу. Уже не отдаленно. Теперб обратного пути нет. Как все быстро поменялось за одну секунду.",
                    "Ко мне подошел мужчина лет 40, с аккуратной бородой, но в грязном свитере( шерсятной свитер с оленями). В руках держал шаурму.",
                    "Это ты? - спросил он меня",
                    "Это я - ответил я",
                    "Давай , друг, я сначал поем,а потом уже все обсудим?",
                    "Хорошо"
            };

   Keyboards keyboards = new Keyboards();

    void Say(Message message) throws InterruptedException {

        for (int i = 0; i <= GREETING.length - 1; i++) {
            master m = new master();
            Keyboards keyboards = new Keyboards();
            SendMessage send = new SendMessage();
            send = m.sendMessager(message);
            send.setText(GREETING[i]);

            try {



                m.sendMessage(send);


            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            Thread.sleep(500);
        }

    }

    void SayName(Message message) throws InterruptedException {
        master m = new master();

        SendMessage send = new SendMessage();
        send = m.sendMessager(message);
        send.setText("Ну привет" + message.getText());

        try {

            m.sendMessage(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        Thread.sleep(500);
    }

    void SayCount(Message message) throws InterruptedException {
        master m = new master();

        SendMessage send = new SendMessage();
        send = m.sendMessager(message);
        send.setText("Ваш счет");


        try {

            m.sendMessage(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        Thread.sleep(500);
    }

}
