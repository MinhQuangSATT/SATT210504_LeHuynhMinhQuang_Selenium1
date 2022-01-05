package PageObjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {
    // Dynamic Locators
    String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";

    // Elements
    protected WebElement getLinkCheckPrice(String departStation, String arriveStation){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, departStation, arriveStation)));
    }

    // Methods
    public void clickLinkCheckPrice(String departStation, String arriveStation){
        Utilities.scrollPage(getLinkCheckPrice(departStation, arriveStation));
        this.getLinkCheckPrice(departStation, arriveStation).click();
    }
}
