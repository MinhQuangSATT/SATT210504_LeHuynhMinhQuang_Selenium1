package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
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

    // Elements
    public WebElement getBookTicketForm()
    {
        return Constant.WEBDRIVER.findElement(frmBookTicketForm);
    }

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

    // Methods
    public boolean checkBookTicketForm()
    {
        return getBookTicketForm().isDisplayed();
    }

    public boolean checkBookTicketPageTitle()
    {
        String title = "Book ticket";
        return this.getLabelPageTitle().getText().equals(title);
    }

    public void bookTicket(String departstation,String arrivestation,String seattype,Integer ticketamount)
    {
        Select selectDepartStation = new Select(getComboBoxDepartStation());
        selectDepartStation.selectByVisibleText(departstation);

        Select selectArriveStation = new Select(getComboBoxArriveStation());
        selectArriveStation.selectByVisibleText(arrivestation);

        Select selectSeatType = new Select(getComboBoxSeatType());
        selectSeatType.selectByVisibleText(seattype);

        Select selectTicketAmount = new Select(getComboBoxTicketAmount());
        selectTicketAmount.selectByVisibleText(String.valueOf(ticketamount));

        this.getButtonBookTicket().click();
    }
}
