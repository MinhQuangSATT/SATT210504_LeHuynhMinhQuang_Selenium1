package PageObjects.Railway;

import Constant.Constant;

public class HomePage extends  GeneralPage{
    // Locators

    // Elements

    // Methods

    public void open()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public boolean checkHomePageTitle()
    {
        String title = "Welcome to Safe Railway";
        return this.getLabelPageTitle().getText().equals(title);
    }
}
