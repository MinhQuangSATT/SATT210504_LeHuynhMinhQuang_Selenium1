package Testcases.Railway;

import Common.Constant;
import Common.Utilities;
import Common.JsonHelper;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TicketPricePage;
import PageObjects.Railway.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.google.gson.JsonObject;

public class TC15 extends TestBase {
    @Test(description = "'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page", dataProvider = "data-provider")
    public void TC15(String departStation,String arriveStation,int priceHS, int priceSS,int priceSSC, int priceHB , int priceSB , int priceSBC) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimetablePage timetablePage = new TimetablePage();
        TicketPricePage ticketPricePage = new TicketPricePage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.NO_BOOKED_TICKET_USERNAME_2,Constant.NO_BOOKED_TICKET_PASSWORD_2);

        System.out.println("3. Click on 'Timetable' tab");
        homePage.gotoTimetable();

        System.out.println("4. Click on 'check price' link of the route from 'Đà Nẵng' to 'Sài Gòn'");
        timetablePage.clickLinkCheckPrice(departStation,arriveStation);

        Assert.assertEquals(ticketPricePage.getTicketPricePageTitle(),"Ticket Price");

        Assert.assertEquals(ticketPricePage.getTicketTableHeader(),String.format("Ticket price from %s to %s",departStation,arriveStation));

        Assert.assertEquals(ticketPricePage.getHSPrice(),String.valueOf(priceHS));
        Assert.assertEquals(ticketPricePage.getSSPrice(),String.valueOf(priceSS));
        Assert.assertEquals(ticketPricePage.getSSCPrice(),String.valueOf(priceSSC));
        Assert.assertEquals(ticketPricePage.getHBPrice(),String.valueOf(priceHB));
        Assert.assertEquals(ticketPricePage.getSBPrice(),String.valueOf(priceSB));
        Assert.assertEquals(ticketPricePage.getSBCPrice(),String.valueOf(priceSBC));
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "/src/main/java/DataObjects/data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation1 = dataTC15.get("departStation").getAsString();
        String arriveStation1 = dataTC15.get("arriveStation").getAsString();
        int price1 = dataTC15.get("HS").getAsInt();
        int price2 = dataTC15.get("SS").getAsInt();
        int price3 = dataTC15.get("SSC").getAsInt();
        int price4 = dataTC15.get("HB").getAsInt();
        int price5 = dataTC15.get("SB").getAsInt();
        int price6 = dataTC15.get("SBC").getAsInt();

        Object[][] object = new Object[][]{
                {departStation1, arriveStation1, price1 , price2 , price3 , price4 , price5 , price6}
        };

        return object;
    }
}
