package Testcases.Railway;

import Common.Utilities;
import Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC04 {
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
    public void TC04() {
        System.out.println("TC04 - User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        homePage.open();

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        LoginPage loginPage = new LoginPage();

        String checkLoginPage = String.valueOf(loginPage.checkLoginPageTitle());
        Assert.assertEquals(checkLoginPage,"true");

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        String checkBookTicketPage = String.valueOf(bookTicketPage.checkBookTicketPageTitle());
        String checkBookTicketForm = String.valueOf(bookTicketPage.checkBookTicketForm());

        Assert.assertEquals(checkBookTicketPage,"true");
        Assert.assertEquals(checkBookTicketForm,"true");
    }
}
