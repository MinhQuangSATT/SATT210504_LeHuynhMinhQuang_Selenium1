package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    // Dynamic Locators
    String btnCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/../td/input[@value='Cancel']";

    // Elements
    protected WebElement getButtonCancel(String departDate, String departStation, String arriveStation, String seatType,int ticketAmount)
    {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancel,departStation,arriveStation,seatType,departDate,String.valueOf(ticketAmount))));
    }

    // Methods
    public void cancelTicket(String departDate, String departStation, String arriveStation, String seatType,int ticketAmount)
    {
        this.getButtonCancel(departDate,departStation,arriveStation,seatType,ticketAmount).click();
    }

    public void acceptAlert() {
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        try { Thread.sleep(Constant.WAITING_TIME); }
        catch(InterruptedException ie) {}
        alert.accept();
    }

    public boolean isCancelButtonDisplayed(String departDate, String departStation, String arriveStation, String seatType,int ticketAmount)
    {
        try
        {
            boolean isDisplayed = getButtonCancel(departDate,departStation,arriveStation,seatType,ticketAmount).isDisplayed();
            return isDisplayed;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
