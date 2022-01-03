package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    // Locators
    private final By frmBookTicketForm = By.xpath("//fieldset");
    private final By cboDate = By.name("Date");
    private final By cboDepartStation = By.name("DepartStation");
    private final By cboArriveStation = By.name("ArriveStation");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblBookTicketErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblBookTicketValidationErrorMsg = By.xpath("//label[@class='validation-error']");

    // Elements
    public WebElement getBookTicketForm() { return Constant.WEBDRIVER.findElement(frmBookTicketForm); }

    public WebElement getComboBoxDate()
    {
        return Constant.WEBDRIVER.findElement(cboDate);
    }

    public WebElement getComboBoxDepartStation()
    {
        return Constant.WEBDRIVER.findElement(cboDepartStation);
    }

    public WebElement getComboBoxArriveStation()
    {
        return Constant.WEBDRIVER.findElement(cboArriveStation);
    }

    public WebElement getComboBoxSeatType() { return Constant.WEBDRIVER.findElement(cboSeatType); }

    public WebElement getComboBoxTicketAmount()
    {
        return Constant.WEBDRIVER.findElement(cboTicketAmount);
    }

    public WebElement getButtonBookTicket()
    {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public WebElement getLabelBookTicketErrorMessage() { return Constant.WEBDRIVER.findElement(lblBookTicketErrorMsg);}

    public WebElement getLabelBookTicketValidationErrorMessage() { return Constant.WEBDRIVER.findElement(lblBookTicketValidationErrorMsg);}

    // Methods
    public boolean checkBookTicketForm()
    {
        return getBookTicketForm().isDisplayed();
    }

    public String getBookTicketPageTitle()
    {
        return this.getLabelPageTitle().getText();
    }

    public void bookTicket(String departStation,String arriveStation,String seatType,Integer ticketAmount)
    {
        Select selectDepartStation = new Select(getComboBoxDepartStation());
        selectDepartStation.selectByVisibleText(departStation);

        try { Thread.sleep(1000); }
        catch(InterruptedException ie) {}

        Select selectArriveStation = new Select(getComboBoxArriveStation());
        selectArriveStation.selectByVisibleText(arriveStation);

        Select selectSeatType = new Select(getComboBoxSeatType());
        selectSeatType.selectByVisibleText(seatType);

        Select selectTicketAmount = new Select(getComboBoxTicketAmount());
        selectTicketAmount.selectByVisibleText(String.valueOf(ticketAmount));

        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,350)", "");

        this.getButtonBookTicket().click();
    }

    public String getSuccessfulBookTicketMessage() { return this.getLabelPageTitle().getText(); }

    public String getBookTicketErrorMessage()
    {
        return this.getLabelBookTicketErrorMessage().getText();
    }

    public String getBookTicketValidationErrorMessage()
    {
        return this.getLabelBookTicketValidationErrorMessage().getText();
    }
}
