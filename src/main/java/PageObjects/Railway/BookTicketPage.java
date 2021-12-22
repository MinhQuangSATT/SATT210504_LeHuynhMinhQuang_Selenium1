package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookTicketPage extends GeneralPage {

    // Locators
    private final By _lblBookTicketTitle = By.xpath("//h1[@align='center']");
    private final By _frmBookTicketForm = By.xpath("//fieldset");

    // Elements
    public WebElement getLblBookTicketTitle()
    {
        return Constant.WEBDRIVER.findElement(_lblBookTicketTitle);
    }

    public WebElement getFrmBookTicketForm()
    {
        return Constant.WEBDRIVER.findElement(_frmBookTicketForm);
    }

    // Methods
    public boolean checkBookTicketTitle()
    {
        return getLblBookTicketTitle().isDisplayed();
    }

    public boolean checkBookTicketForm()
    {
        return getFrmBookTicketForm().isDisplayed();
    }
}
