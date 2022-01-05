package Testcases.Railway;

import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println("3. Enter valid email address and leave other fields empty");
        System.out.println("4. Click on 'Register' button");
        registerPage.register(Utilities.REGISTER_RANDOM_EMAIL(),"","","");

        String actualErrorMessage = registerPage.getRegisterErrorMessage();
        String actualPasswordValidationErrorMessage = registerPage.getPasswordValidationErrorMessage();
        String actualPIDValidationErrorMessage = registerPage.getPIDValidationErrorMessage();

        Assert.assertEquals(actualErrorMessage,"There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(actualPasswordValidationErrorMessage,"Invalid password length");
        Assert.assertEquals(actualPIDValidationErrorMessage,"Invalid ID length");
    }
}
