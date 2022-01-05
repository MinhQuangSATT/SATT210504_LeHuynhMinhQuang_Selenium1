package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    @Test(description = "User can cancel a ticket", dataProvider = "data-provider")
    public void TC16(String departDate,String departStation,String arriveStation,String seatType,int ticketAmount) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.NO_BOOKED_TICKET_USERNAME_3,Constant.NO_BOOKED_TICKET_PASSWORD_3);

        System.out.println("3. Book a ticket");
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket(departDate,departStation,arriveStation,seatType,ticketAmount);

        System.out.println("4. Click on 'My ticket' tab");
        bookTicketPage.gotoMyTicket();

        System.out.println("5. Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.cancelTicket(departDate,departStation,arriveStation,seatType,ticketAmount);

        System.out.println("6. Click on 'OK' button on Confirmation message 'Are you sure?'");
        myTicketPage.acceptAlert();

        Assert.assertFalse(myTicketPage.isCancelButtonDisplayed(departDate,departStation,arriveStation,seatType,ticketAmount));
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "/src/main/java/DataObjects/data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate1 = dataTC16.get("departDate").getAsString();
        String departStation1 = dataTC16.get("departStation").getAsString();
        String arriveStation1 = dataTC16.get("arriveStation").getAsString();
        String seatType1 = dataTC16.get("seatType").getAsString();
        int amount1 = dataTC16.get("ticketAmount").getAsInt();

        Object[][] object = new Object[][]{
                {departDate1, departStation1, arriveStation1, seatType1 , amount1}
        };

        return object;
    }
}
