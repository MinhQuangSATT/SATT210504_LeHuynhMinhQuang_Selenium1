package PageObjects.Railway;

import Constant.Constant;

public class HomePage extends  GeneralPage{
    // Locators

    // Elements

    // Methods

    public HomePage open()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public boolean checkHomePageTitle()
    {
        String title = "Welcome to Safe Railway";
        return this.getLblPageTitle().getText().equals(title);
    }
}
