package Testcases.Railway;

import Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println("3. Enter valid information into all fields");
        System.out.println("4. Click on 'Register' button");
        registerPage.register(Constant.REGISTER_RANDOM_EMAIL(),Constant.REGISTER_PASSWORD,Constant.REGISTER_CONFIRM_PASSWORD,Constant.REGISTER_PID);

        String actualMessage = registerPage.getRegisterSuccessMessage();
        String expectedMessage = "Thank you for registering your account";

        Assert.assertEquals(actualMessage,expectedMessage,"Successful register message is not displayed as expected");
    }
}
