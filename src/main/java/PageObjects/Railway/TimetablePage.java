package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {
    // Locators
    public String departStation="Đà Nẵng";
    public String arriveStation="Sài Gòn";

    private final By lblCheckPrice = By.xpath(String.format("//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a",departStation,arriveStation));

    // Elements
    public WebElement getLabelTicketCheckPrice()
    {
        return Constant.WEBDRIVER.findElement(lblCheckPrice);
    }

    // Methods
    public void getTicketCheckPrice()
    {
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,350)", "");
        this.getLabelTicketCheckPrice().click();
    }
}
