package Testcases.Railway;

import Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {
    @Test(description = "TC05 - System shows message when user enter wrong password several times")
    public void TC05() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println("3. Enter valid information into 'Username' textbox except 'Password' textbox.");
        System.out.println("4. Click on 'Login' button");
        System.out.println("5. Repeat step 3 three more times.");
        loginPage.loginMultipleTimes(Constant.USERNAME,Constant.INVALID_PASSWORD,4);

        String actualMsg = loginPage.getLoginErrorMessage();

        Assert.assertEquals(actualMsg,"You have used 4 out of 5 login attempts.After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}
