package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    @Test(description = "TC09 - User can't change password when 'New Password' and 'Confirm Password' are different.", dataProvider = "data-provider")
    public void TC09(String newPassword, String currentPassword, String confirmPassword) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("3. Click on 'Change Password' tab");
        homePage.gotoChangePassword();

        System.out.println("4. Enter valid information into 'Current Password' textbox but " + "enter 'a123:\"/{}!@$' into 'New Password' textbox " + "and 'b456:\"/{}!@$' into 'Confirm Password' textbox.");
        changePasswordPage.changePassword(newPassword,currentPassword,confirmPassword);

        String actualMessage = changePasswordPage.getChangePasswordErrorMessage();
        String expectedMessage = "Password change failed. Please correct the errors and try again.";

        String actualConfirmPasswordValidationMessage = changePasswordPage.getConfirmPasswordValidationErrorMessage();
        String expectedConfirmPasswordValidationMessage = "The password confirmation does not match the new password.";

        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected");
        Assert.assertEquals(actualConfirmPasswordValidationMessage,expectedConfirmPasswordValidationMessage,"Confirm password validation error message is not displayed as expected");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "/src/main/java/DataObjects/data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC09 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String newPassword1 = dataTC09.get("newPassword").getAsString();
        String currentPassword1 = dataTC09.get("currentPassword").getAsString();
        String confirmPassword1 = dataTC09.get("confirmPassword").getAsString();

        Object[][] object = new Object[][]{
                {newPassword1, currentPassword1, confirmPassword1}
        };

        return object;
    }
}
