package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test(description = "User can book many tickets at a time", dataProvider = "data-provider")
    public void TC14(String departDate,String departStation,String arriveStation,String seatType,int ticketAmount) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.NO_BOOKED_TICKET_USERNAME_1,Constant.NO_BOOKED_TICKET_PASSWORD_1);

        System.out.println("3. Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        System.out.println("4. Select a Depart date from the list");
        System.out.println("5. Select 'Nha Trang' for 'Depart from' and 'Sài Gòn' for 'Arrive at'.");
        System.out.println("6. Select 'Soft seat with air conditioner' for 'Seat type'");
        System.out.println("7. Select '5' for 'Ticket amount'");
        System.out.println("8. Click on 'Book ticket' button");
        bookTicketPage.bookTicket(departDate,departStation,arriveStation,seatType,ticketAmount);

        Assert.assertEquals(bookTicketPage.getSuccessfulBookTicketMessage(),"Ticket Booked Successfully!");

        Assert.assertEquals(bookTicketPage.getDepartDateAfterBooking(),departDate);
        Assert.assertEquals(bookTicketPage.getDepartStationAfterBooking(),departStation);
        Assert.assertEquals(bookTicketPage.getArriveStationAfterBooking(),arriveStation);
        Assert.assertEquals(bookTicketPage.getSeatTypeAfterBooking(),seatType);
        Assert.assertEquals(bookTicketPage.getAmountAfterBooking(),String.valueOf(ticketAmount));
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "/src/main/java/DataObjects/data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate1 = dataTC14.get("departDate").getAsString();
        String departStation1 = dataTC14.get("departStation").getAsString();
        String arriveStation1 = dataTC14.get("arriveStation").getAsString();
        String seatType1 = dataTC14.get("seatType").getAsString();
        int amount1 = dataTC14.get("ticketAmount").getAsInt();

        Object[][] object = new Object[][]{
                {departDate1, departStation1, arriveStation1, seatType1 , amount1}
        };

        return object;
    }
}
