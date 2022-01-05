package PageObjects.Railway;

public class ContactPage extends GeneralPage {
    // Locators

    // Elements

    // Methods
    public String getContactPageTitle()
    {
        return this.getLabelPageTitle().getText();
    }
}
