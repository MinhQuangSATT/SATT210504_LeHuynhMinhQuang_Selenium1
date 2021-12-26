package Testcases.Railway;

import Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase {
    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Pre-condition: Create a new account but do not activate it");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println("3. Enter username and password of account hasn't been activated.");
        System.out.println("4. Click on 'Login' button");
        loginPage.login(Constant.INVALID_EMAIL,Constant.INVALID_PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected.");
    }
}
