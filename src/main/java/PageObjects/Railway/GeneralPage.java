package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Common.Constant;

public class GeneralPage {
    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    private final By lblPageTitle = By.xpath("//h1[@align='center']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");

    // Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket() { return Constant.WEBDRIVER.findElement(tabBookTicket); }

    protected WebElement getLabelWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabContact() { return Constant.WEBDRIVER.findElement(tabContact); }

    protected WebElement getLabelPageTitle() { return Constant.WEBDRIVER.findElement(lblPageTitle); }

    protected WebElement getTabRegister() { return Constant.WEBDRIVER.findElement(tabRegister); }

    protected WebElement getTabChangePassword() { return Constant.WEBDRIVER.findElement(tabChangePassword); }

    protected WebElement getTabMyTicket() { return Constant.WEBDRIVER.findElement(tabMyTicket); }

    protected WebElement getTabTimeTable() { return Constant.WEBDRIVER.findElement(tabTimetable); }

    // Methods
    public String getWelcomeMessage()
    {
        return this.getLabelWelcomeMessage().getText();
    }

    public void gotoLoginPage()
    {
        this.getTabLogin().click();
    }

    public void gotoBookTicketPage()
    {
        this.getTabBookTicket().click();
    }

    public void gotoContactPage()
    {
        this.getTabContact().click();
    }

    public void clickTabLogout()
    {
        this.getTabLogout().click();
    }

    public void gotoRegisterPage()
    {
        this.getTabRegister().click();
    }

    public void gotoChangePassword()
    {
        this.getTabChangePassword().click();
    }

    public void gotoMyTicket()
    {
        this.getTabMyTicket().click();
    }

    public void gotoTimetable() { this.getTabTimeTable().click(); }

    public boolean isTabLogout()
    {
        try
        {
            boolean isDisplayed = getTabLogout().isDisplayed();
            return isDisplayed;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
