package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    // Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    // Elements
    public WebElement getTextUsername()
    {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTextPassword()
    {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getButtonLogin()
    {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLabelLoginErrorMessage()
    {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    // Methods
    public void login(String username,String password)
    {
        //Submit login credentials
        this.getTextUsername().sendKeys(username);
        this.getTextPassword().sendKeys(password);
        this.getButtonLogin().click();
    }

    public String getLoginErrorMessage()
    {
        return this.getLabelLoginErrorMessage().getText();
    }

    public String getLoginPageTitle()
    {
        return this.getLabelPageTitle().getText();
    }

    public void loginMultipleTimes(String username,String password,int number)
    {
        for(int index = 1;index <= number;index++)
        {
            this.login(username,password);
            this.getTextUsername().clear();
        }
    }
}
