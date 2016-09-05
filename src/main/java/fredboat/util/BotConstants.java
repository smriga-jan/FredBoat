package fredboat.util;

import fredboat.FredBoat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BotConstants {

    public static final String OWNER_ID = "81011298891993088";
    public static final String MUSIC_BOT_ID = "150376112944447488";
    public static final String BETA_BOT_ID = "152691313123393536";
    public static final String MAIN_BOT_ID = "150376112944447488";
    
    public static final boolean IS_BETA = System.getProperty("os.name").toLowerCase().contains("windows");
    public static final String HELP_TEXT = getHelpText();
    public static String CLIENT_ID = IS_BETA ? "168672778860494849" : "168686772216135681";
    
    public static final String DEFAULT_BOT_PREFIX = IS_BETA ? "¤" : ";;";
    public static final String DEFAULT_SELF_PREFIX = IS_BETA ? "::" : "<<";
    public static final boolean DEBUG_BETA_USE_CUSTOM_PREFIXES = false;//TODO
    
    //Get the help text from file
    private static String getHelpText(){
        try {
            String str = "";
            
            InputStream helpIS = new BotConstants().getClass().getClassLoader().getResourceAsStream("help.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(helpIS));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                str = str + inputLine + "\n";
            }
            in.close();
            
            return str;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
