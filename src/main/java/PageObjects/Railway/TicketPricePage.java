package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {
    // Locators
    private final By lblTicketTableName = By.xpath("//th[@colspan='7']");

    // Elements
    public WebElement getLabelTicketTableName()
    {
        return Constant.WEBDRIVER.findElement(lblTicketTableName);
    }

    // Methods
    public String getTicketPricePageTitle()
    {
        return this.getLabelPageTitle().getText();
    }

    public String getTicketTableName()
    {
        return this.getLabelTicketTableName().getText();
    }
}
