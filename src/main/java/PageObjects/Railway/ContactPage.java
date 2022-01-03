package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {
    // Locators

    // Elements

    // Methods
    public String getContactPageTitle()
    {
        return this.getLabelPageTitle().getText();
    }
}
