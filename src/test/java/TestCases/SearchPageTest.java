package TestCases;

import Base.base;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.Searchpage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class SearchPageTest extends base {

    LoginPage login = new LoginPage();

    RegisterPage register = new RegisterPage();
    Searchpage search = new Searchpage();

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @Test
    public void searchTest() throws InterruptedException, AWTException {

        register.clickOnLogin();
        Thread.sleep(10000);
        //Login form validation
        login.fillLoginForm("manuxavier971@gmail.com","manu1910");
        //Selecting Company from dropdown
        search.selectValueFromDropdown("Company", "EngageDXB");
        //Passing the required page name and searching for that
        search.searchForElement("EngageDXB");
        //Validating page gets successfully loaded or not
        String searchPageName = search.validatePage();
        Assert.assertEquals(searchPageName,"EngageDXB");


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
