package Testcases.Railway;

import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import Common.Utilities;
import Constant.Constant;

public class LoginTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver",Utilities.getProjectPath()
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
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login("",Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();

        Assert.assertEquals(actualMsg,"There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC03() {
        System.out.println("User can not log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME,Constant.INVALID_PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();

        Assert.assertEquals(actualMsg,"There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC04() {
        System.out.println("User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        homePage.open();

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        LoginPage loginPage;

        String checkLoginPage = String.valueOf(loginPage.checkLoginPageTitle());

        Assert.assertEquals(checkLoginPage,"true");

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        String checkBookTicketPage = String.valueOf(bookTicketPage.checkBookTicketTitle());
        String checkBookTicketForm = String.valueOf(bookTicketPage.checkBookTicketForm());

        Assert.assertEquals(checkBookTicketPage,"true");
        Assert.assertEquals(checkBookTicketForm,"true");
    }
}
