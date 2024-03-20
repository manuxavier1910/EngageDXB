package TestCases;

import Base.base;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Random;

public class LoginPageTest extends base {

    LoginPage login = new LoginPage();
    RegisterPage register = new RegisterPage();

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @Test
    public void loginTest() throws InterruptedException, AWTException {

        register.clickOnLogin();
        Thread.sleep(10000);
        //Login form validation
        login.fillLoginForm("manuxavier971@gmail.com","manu1910");
        //User login success validation
        String actualUsername = login.isUserLoginSuccesValidation();
        Assert.assertEquals(actualUsername,"Manu Xavier");

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
