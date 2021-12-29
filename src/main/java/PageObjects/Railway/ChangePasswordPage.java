package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    // Locators
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By lblChangePasswordErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblConfirmPasswordValidationErrorMsg = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");

    // Elements
    public WebElement getTextCurrentPassword()
    {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    public WebElement getTextNewPassword()
    {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    public WebElement getTextConfirmPassword() { return Constant.WEBDRIVER.findElement(txtConfirmPassword); }

    public WebElement getButtonChangePassword()
    {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    public WebElement getLabelChangePasswordErrorMessage() { return Constant.WEBDRIVER.findElement(lblChangePasswordErrorMsg); }

    public WebElement getLabelConfirmPasswordValidationErrorMessage() { return Constant.WEBDRIVER.findElement(lblConfirmPasswordValidationErrorMsg); }

    // Methods
    public void changePassword(String currentpassword,String newpassword,String confirmpassword)
    {
        //Submit register credentials
        this.getTextCurrentPassword().sendKeys(currentpassword);
        this.getTextNewPassword().sendKeys(newpassword);
        this.getTextConfirmPassword().sendKeys(confirmpassword);
        this.getButtonChangePassword().click();
    }

    public String getChangePasswordErrorMessage()
    {
        return this.getLabelChangePasswordErrorMessage().getText();
    }

    public String getConfirmPasswordValidationErrorMessage()
    {
        return this.getLabelConfirmPasswordValidationErrorMessage().getText();
    }
}
