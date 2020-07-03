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


   ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    int count = 0;
    Fight fight = new Fight();

    public void setButtons(SendMessage sendMessage) {
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        keyboardRowList.clear();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Help");
        keyboardFirstRow.add("Setting");
        keyboardFirstRow.add("Counter");
        keyboardFirstRow.add("Weapon");
        keyboardFirstRow.add("Inventory");

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(""+fight.WEAPON_ENEMY_1);
        keyboardSecondRow.add(""+fight.WEAPON_ENEMY_1);
        keyboardSecondRow.add(""+fight.WEAPON_ENEMY_1);
        keyboardSecondRow.add(""+fight.WEAPON_ENEMY_1);
        keyboardSecondRow.add(""+fight.WEAPON_ENEMY_1);

        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(""+fight.WEAPON_1);
        keyboardFourthRow.add(""+fight.WEAPON_2);
        keyboardFourthRow.add(""+fight.WEAPON_3);
        keyboardFourthRow.add(""+fight.WEAPON_4);
        keyboardFourthRow.add(""+fight.WEAPON_5);


        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("A" + count);
        keyboardThirdRow.add("B" + count);
        keyboardThirdRow.add("C" + count);
        keyboardThirdRow.add("D" + count);
        keyboardThirdRow.add("E" + count);


        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        keyboardRowList.add(keyboardFourthRow);
        keyboardRowList.add(keyboardThirdRow);


        replyKeyboardMarkup.setKeyboard(keyboardRowList);


    }


}
