package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {
    // Locators

    // Elements

    // Methods
    public boolean checkContactPageTitle()
    {
        String title = "Contact Information";
        return this.getLabelPageTitle().getText().equals(title);
    }
}
