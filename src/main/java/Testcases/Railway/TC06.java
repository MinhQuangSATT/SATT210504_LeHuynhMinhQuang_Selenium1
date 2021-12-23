package Testcases.Railway;

import Common.Utilities;
import Constant.Constant;
import PageObjects.Railway.ContactPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC06 {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()
                + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");

        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC06() {
        System.out.println("TC06 - User is redirected to Home page after logging out");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        ContactPage contactPage = homePage.gotoContactPage();

        contactPage.clickTabLogout();

        String checkHomePage = String.valueOf(homePage.checkHomePageTitle());
        Assert.assertEquals(checkHomePage,"true");

        String checkTabLogout = String.valueOf(homePage.checkTabLogout());
        Assert.assertEquals(checkTabLogout,"false");
    }
}
