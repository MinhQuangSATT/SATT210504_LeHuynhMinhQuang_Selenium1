package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    // Locators
    public String departStation="Nha Trang";
    public String arriveStation="Sài Gòn";

    private final By lblDepartStation = By.xpath(String.format("//td[text()='%s']",departStation));
    private final By lblArriveStation = By.xpath(String.format("//td[text()='%s']/following-sibling::td[text()='%s']",departStation,arriveStation));
    private final By lblSeatType = By.xpath(String.format("//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]",departStation,arriveStation));
    private final By lblTicketAmount = By.xpath(String.format("//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Amount']/preceding-sibling::th)+1]",departStation,arriveStation));
    private final By btnCancel = By.xpath("//input[@value='Cancel']");

    //@FindBy(how=How.XPATH , using = String.format("//td[text()='%s']",departStation))
    //private WebElement DepartStationXpath;

    // Elements
    public WebElement getLabelTicketDepartStation()
    {
        return Constant.WEBDRIVER.findElement(lblDepartStation);
    }

    public WebElement getLabelTicketArriveStation()
    {
        return Constant.WEBDRIVER.findElement(lblArriveStation);
    }

    public WebElement getLabelTicketSeatType()
    {
        return Constant.WEBDRIVER.findElement(lblSeatType);
    }

    public WebElement getLabelTicketAmount()
    {
        return Constant.WEBDRIVER.findElement(lblTicketAmount);
    }

    public WebElement getButtonCancel()
    {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    // Methods
    public String getBookedTicketDepartStation()
    {
        return this.getLabelTicketDepartStation().getText();
    }

    public String getBookedTicketArriveStation()
    {
        return this.getLabelTicketArriveStation().getText();
    }

    public String getBookedTicketSeatType()
    {
        return this.getLabelTicketSeatType().getText();
    }

    public String getBookedTicketAmount()
    {
        return this.getLabelTicketAmount().getText();
    }

    public void cancelTicket()
    {
        this.getButtonCancel().click();
    }

    public void acceptAlert() {
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        try { Thread.sleep(1000); }
        catch(InterruptedException ie) {}
        alert.accept();
    }

    public boolean isCancelButtonDisplayed()
    {
        try
        {
            boolean isDisplayed = getButtonCancel().isDisplayed();
            return isDisplayed;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
