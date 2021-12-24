package Testcases.Railway;

import Constant.Constant;
import PageObjects.Railway.ContactPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC06() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ContactPage contactPage =  new ContactPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with valid Email and Password");
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("3. Click on 'Contact' tab");
        homePage.gotoContactPage();

        System.out.println("4. Click on 'Log out' tab");
        contactPage.clickTabLogout();

        String checkHomePage = String.valueOf(homePage.checkHomePageTitle());
        Assert.assertEquals(checkHomePage,"true");

        String checkTabLogout = String.valueOf(homePage.checkTabLogout());
        Assert.assertEquals(checkTabLogout,"false");
    }
}
