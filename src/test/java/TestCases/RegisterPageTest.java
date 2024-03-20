package TestCases;

import Base.base;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterPageTest extends base {

    RegisterPage register = new RegisterPage();

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }

    @Test
    public void registerTest() throws InterruptedException {

        register.clickOnLogin();
        Thread.sleep(10000);
        register.clickOnRegister();
        //Register URL validation
        String actualRegisterUrl=register.validateRegisterUrl();
        Assert.assertEquals(actualRegisterUrl,"https://www.engagedxb.gov.ae/account/registration");
        //Logo validation
        boolean flag = register.validateLogo();
        Assert.assertTrue(flag);
        //Header validation
        String actualHeader = register.validateHeader();
        Assert.assertEquals(actualHeader,"Register");
        //Form1 validation
        Random rand = new Random();
        int count = rand.nextInt(1000000007);
        int count2 = ++count;
        String successText = register.fillForm1("Anusree","Anusree");
        Assert.assertEquals(successText,"Great!");
        Thread.sleep(2000);
        //Form2 validation
        register.fillForm2("anusree"+count2+"@gmail.com","anusree123");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
