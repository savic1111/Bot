import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Keyboards {

    Update update;
    Model model = new Model();
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    int count =0;

    public void setButtons(SendMessage sendMessage) {
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
keyboardRowList.clear();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Help - " + count);
        keyboardFirstRow.add("Setting");
        keyboardFirstRow.add("Counter");
        keyboardFirstRow.add("Weapon");
        keyboardFirstRow.add("Inventory");

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("0");
        keyboardSecondRow.add("0");
        keyboardSecondRow.add("0");
        keyboardSecondRow.add("0");
        keyboardSecondRow.add("0");



        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Help - " + count);
        keyboardThirdRow.add("Help - " + count);
        keyboardThirdRow.add("Help - " + count);
        keyboardThirdRow.add("Help - " + count);
        keyboardThirdRow.add("Help - " + count);



        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        keyboardRowList.add(keyboardThirdRow);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);


    }


}
