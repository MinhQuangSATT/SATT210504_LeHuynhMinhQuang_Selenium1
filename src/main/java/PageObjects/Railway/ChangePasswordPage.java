package PageObjects.Railway;

import Common.Constant;
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
    protected WebElement getTextCurrentPassword()
    {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    protected WebElement getTextNewPassword()
    {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    protected WebElement getTextConfirmPassword() { return Constant.WEBDRIVER.findElement(txtConfirmPassword); }

    protected WebElement getButtonChangePassword()
    {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    protected WebElement getLabelChangePasswordErrorMessage() { return Constant.WEBDRIVER.findElement(lblChangePasswordErrorMsg); }

    protected WebElement getLabelConfirmPasswordValidationErrorMessage() { return Constant.WEBDRIVER.findElement(lblConfirmPasswordValidationErrorMsg); }

    // Methods
    public void changePassword(String currentPassword,String newPassword,String confirmPassword)
    {
        this.getTextCurrentPassword().sendKeys(currentPassword);
        this.getTextNewPassword().sendKeys(newPassword);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
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
