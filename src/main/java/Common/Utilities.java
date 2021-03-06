package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Utilities {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    static String getAlphaNumericString(int n)
    {
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char)nextRandomChar);
        }
        return r.toString();
    }

    public static final String REGISTER_RANDOM_EMAIL ()
    {
        int n = 10;
        return java.time.LocalTime.now()+getAlphaNumericString(n)+"@email.com";
    }

    public static void scrollPage(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
}
