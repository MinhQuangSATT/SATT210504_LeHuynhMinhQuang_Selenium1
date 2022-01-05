package PageObjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    // Locators
    private final By frmBookTicketForm = By.xpath("//fieldset");
    private final By cboDepartDate = By.name("Date");
    private final By cboDepartStation = By.name("DepartStation");
    private final By cboArriveStation = By.name("ArriveStation");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblBookTicketErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblTicketAmountValidationErrorMsg = By.xpath("//label[@class='validation-error']");

    private final By txtDepartDateAfterBooking = By.xpath("//td[count(//th[text()='Depart Date']//preceding-sibling::th)+1]");
    private final By txtDepartStationAfterBooking = By.xpath("//td[count(//th[text()='Depart Station']//preceding-sibling::th)+1]");
    private final By txtArriveStationAfterBooking = By.xpath("//td[count(//th[text()='Arrive Station']//preceding-sibling::th)+1]");
    private final By txtSeatTypeAfterBooking = By.xpath("//td[count(//th[text()='Seat Type']//preceding-sibling::th)+1]");
    private final By txtAmountAfterBooking = By.xpath("//td[count(//th[text()='Amount']//preceding-sibling::th)+1]");

    // Elements
    protected WebElement getBookTicketForm() { return Constant.WEBDRIVER.findElement(frmBookTicketForm); }

    protected WebElement getComboBoxDepartDate()
    {
        return Constant.WEBDRIVER.findElement(cboDepartDate);
    }

    protected WebElement getComboBoxDepartStation()
    {
        return Constant.WEBDRIVER.findElement(cboDepartStation);
    }

    protected WebElement getComboBoxArriveStation()
    {
        return Constant.WEBDRIVER.findElement(cboArriveStation);
    }

    protected WebElement getComboBoxSeatType() { return Constant.WEBDRIVER.findElement(cboSeatType); }

    protected WebElement getComboBoxTicketAmount()
    {
        return Constant.WEBDRIVER.findElement(cboTicketAmount);
    }

    protected WebElement getButtonBookTicket()
    {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getLabelBookTicketErrorMessage() { return Constant.WEBDRIVER.findElement(lblBookTicketErrorMsg);}

    protected WebElement getLabelTicketAmountValidationErrorMessage() { return Constant.WEBDRIVER.findElement(lblTicketAmountValidationErrorMsg);}

    protected WebElement getTextDepartDateAfterBooking() { return Constant.WEBDRIVER.findElement(txtDepartDateAfterBooking); }

    protected WebElement getTextDepartStationAfterBooking() { return Constant.WEBDRIVER.findElement(txtDepartStationAfterBooking); }

    protected WebElement getTextArriveStationAfterBooking() { return Constant.WEBDRIVER.findElement(txtArriveStationAfterBooking); }

    protected WebElement getTextSeatTypeAfterBooking() { return Constant.WEBDRIVER.findElement(txtSeatTypeAfterBooking); }

    protected WebElement getTextAmountAfterBooking() { return Constant.WEBDRIVER.findElement(txtAmountAfterBooking); }

    // Methods
    public boolean checkBookTicketForm()
    {
        return getBookTicketForm().isDisplayed();
    }

    public String getBookTicketPageTitle()
    {
        return this.getLabelPageTitle().getText();
    }

    public void bookTicket(String Date,String departStation,String arriveStation,String seatType,Integer ticketAmount)
    {
        Select selectDate = new Select(getComboBoxDepartDate());
        selectDate.selectByVisibleText(Date);

        Select selectDepartStation = new Select(getComboBoxDepartStation());
        selectDepartStation.selectByVisibleText(departStation);

        try { Thread.sleep(Constant.WAITING_TIME); }
        catch(InterruptedException ie) {}

        Select selectArriveStation = new Select(getComboBoxArriveStation());
        selectArriveStation.selectByVisibleText(arriveStation);

        Select selectSeatType = new Select(getComboBoxSeatType());
        selectSeatType.selectByVisibleText(seatType);

        Select selectTicketAmount = new Select(getComboBoxTicketAmount());
        selectTicketAmount.selectByVisibleText(String.valueOf(ticketAmount));

        Utilities.scrollPage(getButtonBookTicket());

        this.getButtonBookTicket().click();
    }

    public String getSuccessfulBookTicketMessage() { return this.getLabelPageTitle().getText(); }

    public String getBookTicketErrorMessage()
    {
        return this.getLabelBookTicketErrorMessage().getText();
    }

    public String getTicketAmountValidationErrorMessage()
    {
        return this.getLabelTicketAmountValidationErrorMessage().getText();
    }

    public String getDepartDateAfterBooking() { return this.getTextDepartDateAfterBooking().getText(); }

    public String getDepartStationAfterBooking() { return this.getTextDepartStationAfterBooking().getText(); }

    public String getArriveStationAfterBooking() { return this.getTextArriveStationAfterBooking().getText(); }

    public String getSeatTypeAfterBooking() { return this.getTextSeatTypeAfterBooking().getText(); }

    public String getAmountAfterBooking() { return this.getTextAmountAfterBooking().getText(); }
}
