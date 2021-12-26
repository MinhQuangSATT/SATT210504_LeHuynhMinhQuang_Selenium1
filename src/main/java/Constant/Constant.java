package Constant;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway.somee.com/";
    public static final String USERNAME = "hehehe@mailinator.com";
    public static final String PASSWORD = "123456789";
    public static final String INVALID_EMAIL = "123@mailinator.com";
    public static final String INVALID_PASSWORD = PASSWORD+"123";

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
        return getAlphaNumericString(n)+"email.com";
    }
    public static final String REGISTER_PASSWORD = "123456789";
    public static final String REGISTER_CONFIRM_PASSWORD = "123456789";
    public static final String REGISTER_PID = "123456789";
}
