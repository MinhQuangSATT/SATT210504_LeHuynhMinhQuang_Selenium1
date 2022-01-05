package PageObjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    // Locators
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblRegisterSuccessMsg = By.xpath("//div[@id='content']");
    private final By lblPasswordValidationErrorMsg = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By lblPIDValidationErrorMsg = By.xpath("//label[@for='pid' and @class='validation-error']");

    // Elements
    protected WebElement getTextEmail()
    {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    protected WebElement getTextPassword()
    {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getTextConfirmPassword()
    {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getTextPID()
    {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    protected WebElement getButtonRegister()
    {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    protected WebElement getLabelRegisterErrorMessage()
    {
        return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg);
    }

    protected WebElement getLabelRegisterSuccessMessage()
    {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccessMsg);
    }

    protected WebElement getLabelPasswordValidationErrorMessage()
    {
        return Constant.WEBDRIVER.findElement(lblPasswordValidationErrorMsg);
    }

    protected WebElement getLabelPIDValidationErrorMessage()
    {
        return Constant.WEBDRIVER.findElement(lblPIDValidationErrorMsg);
    }

    // Methods
    public void register(String username,String password,String confirmPassword ,String pid)
    {
        this.getTextEmail().sendKeys(username);
        this.getTextPassword().sendKeys(password);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getTextPID().sendKeys(pid);

        Utilities.scrollPage(getButtonRegister());

        this.getButtonRegister().click();
    }

    public String getRegisterErrorMessage()
    {
        return this.getLabelRegisterErrorMessage().getText();
    }

    public String getRegisterSuccessMessage()
    {
        return this.getLabelRegisterSuccessMessage().getText();
    }

    public String getPasswordValidationErrorMessage()
    {
        return this.getLabelPasswordValidationErrorMessage().getText();
    }

    public String getPIDValidationErrorMessage()
    {
        return this.getLabelPIDValidationErrorMessage().getText();
    }
}
