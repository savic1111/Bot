import com.vdurmont.emoji.EmojiParser;
public class Smiles {

    public enum Smile {
        PLUS(":heavy_plus_sign:"),
        MINUS(":heavy_minus_sign:"),
        CHECK(":white_check_mark:"),
        NOT(":x:"),
        DOUBT(":zzz:"),
        FLAG(":checkered_flag:");

    private String value;
    public String get() {
        return EmojiParser.parseToUnicode(value);
    }

        Smile(String value) {
            this.value = value;
        }
    }
}


