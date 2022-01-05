package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    @Test(description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC04() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login Page");

        System.out.println("3. Login with valid account");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        String checkBookTicketForm = String.valueOf(bookTicketPage.checkBookTicketForm());

        Assert.assertEquals(bookTicketPage.getBookTicketPageTitle(),"Book ticket");
        Assert.assertEquals(checkBookTicketForm,"true");
    }
}
