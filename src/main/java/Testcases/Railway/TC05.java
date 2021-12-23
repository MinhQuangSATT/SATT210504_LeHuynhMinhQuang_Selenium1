package Testcases.Railway;

import Common.Utilities;
import Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC05 {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()
                + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");

        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enter wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME,Constant.INVALID_PASSWORD);

        for (int i = 1;i <= 3;i++)
        {
            loginPage.login("",Constant.INVALID_PASSWORD);
        }

        String actualMsg = loginPage.getLoginErrorMsg();

        Assert.assertEquals(actualMsg,"You have used 4 out of 5 login attempts.After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}
