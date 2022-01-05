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

public class TC17 extends TestBase {
    @Test(description = "User can't book more than 10 tickets", dataProvider = "data-provider")
    public void TC17(String departDate1,String departStation1,String arriveStation1,String seatType1,int ticketAmount1,String departDate2,String departStation2,String arriveStation2,String seatType2,int ticketAmount2) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.NO_BOOKED_TICKET_USERNAME_4,Constant.NO_BOOKED_TICKET_PASSWORD_4);

        System.out.println("3. Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        System.out.println("4. Book 10 tickets");
        bookTicketPage.bookTicket(departDate1,departStation1,arriveStation1,seatType1,ticketAmount1);

        System.out.println("5. Click on 'Book ticket' tab again");
        bookTicketPage.gotoBookTicketPage();

        System.out.println("6. Book one more ticket");
        bookTicketPage.bookTicket(departDate2,departStation2,arriveStation2,seatType2,ticketAmount2);

        String actualErrorMessage = bookTicketPage.getBookTicketErrorMessage();
        String actualValidationErrorMessage = bookTicketPage.getTicketAmountValidationErrorMessage();

        Assert.assertEquals(actualErrorMessage,"There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(actualValidationErrorMessage,"You have booked 10 tickets. You can book no more.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "/src/main/java/DataObjects/data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate1 = dataTC17.get("departDate1").getAsString();
        String departStation1 = dataTC17.get("departStation1").getAsString();
        String arriveStation1 = dataTC17.get("arriveStation1").getAsString();
        String seatType1 = dataTC17.get("seatType1").getAsString();
        int amount1 = dataTC17.get("ticketAmount1").getAsInt();

        String departDate2 = dataTC17.get("departDate2").getAsString();
        String departStation2 = dataTC17.get("departStation2").getAsString();
        String arriveStation2 = dataTC17.get("arriveStation2").getAsString();
        String seatType2 = dataTC17.get("seatType2").getAsString();
        int amount2 = dataTC17.get("ticketAmount2").getAsInt();

        Object[][] object = new Object[][]{
                {departDate1, departStation1, arriveStation1, seatType1 , amount1, departDate2, departStation2, arriveStation2, seatType2 , amount2}
        };

        return object;
    }
}
