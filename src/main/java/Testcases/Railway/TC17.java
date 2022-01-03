package Testcases.Railway;

import Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    @Test(description = "")
    public void TC17() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        System.out.println("4. Book 10 tickets");
        bookTicketPage.bookTicket("Sài Gòn","Phan Thiết","Hard seat",10);

        System.out.println("5. Click on 'Book ticket' tab again");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("6. Book one more ticket");
        bookTicketPage.bookTicket("Sài Gòn","Phan Thiết","Hard seat",1);

        String actualErrorMessage = bookTicketPage.getBookTicketErrorMessage();
        String actualValidationErrorMessage = bookTicketPage.getBookTicketValidationErrorMessage();

        Assert.assertEquals(actualErrorMessage,"There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(actualValidationErrorMessage,"You have booked 10 tickets. You can book no more.");
    }
}
