package fredboat.command.other;

import fredboat.feature.I18n;
import fredboat.testutil.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;

public class CommandsHelpTest extends BaseTest {

    @Test
    public void testTranslatedString1() {
        I18n.start();

        ResourceBundle id_ID = I18n.DEFAULT.getProps();
        String key = "helpUptimeCommand";

        Assertions.assertNotNull(id_ID.getString(key), new Supplier<String>() {
            @Override
            public String get() {
                return "Shows uptime of this bot.";
            }
        });
    }

    @Test
    public void testTranslatedString2() {
        I18n.start();

        ResourceBundle id_ID = I18n.DEFAULT.getProps();
        String key = "helpSayCommand";

        Assertions.assertNotNull(id_ID.getString(key), new Supplier<String>() {
            @Override
            public String get() {
                return "Make the bot echo something.";
            }
        });
    }

    @Test
    public void testTranslatedStringStub() {
        StubLanguage stubLang = new StubLanguage("te","ST");
        HashMap<String, StubLanguage> langList = new HashMap<>();
        langList.put(stubLang.getCode(),stubLang);

        StubLanguage id_ID = langList.get("te_ST");
        String key = "testKey";

        Assertions.assertNotNull(id_ID.getString(key), new Supplier<String>() {
            @Override
            public String get() {
                return "testValue";
            }
        });
    }
}

class StubLanguage {
    private String code;
    private Locale locale;
    private HashMap<String, String> map = new HashMap<String, String>();

    StubLanguage(String language, String country) {

        code = language + "_" + country;
        locale = new Locale(language, country);

        map.put("testKey", "testValue");

    }
    public String getCode() {
        return code;
    }

    public String getString(String key){
        return map.get(key);
    }
}