package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {

    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    private final By lblPageTitle = By.xpath("//h1[@align='center']");

    // Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket() { return Constant.WEBDRIVER.findElement(tabBookTicket); }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabContact() { return Constant.WEBDRIVER.findElement(tabContact); }

    public WebElement getLblPageTitle() { return Constant.WEBDRIVER.findElement(lblPageTitle); }

    // Methods
    public String getWelcomeMessage()
    {
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage()
    {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookTicketPage gotoBookTicketPage()
    {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public ContactPage gotoContactPage()
    {
        this.getTabContact().click();
        return new ContactPage();
    }

    public void clickTabLogout()
    {
        this.getTabLogout().click();
        return;
    }

    public boolean checkTabLogout()
    {
        try
        {
            Constant.WEBDRIVER.findElement(tabLogout);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
