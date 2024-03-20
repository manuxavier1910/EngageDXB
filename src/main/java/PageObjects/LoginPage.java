package PageObjects;

import Base.base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginPage extends base{

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void fillLoginForm(String email, String pass) throws InterruptedException, AWTException {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(email);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
        Thread.sleep(5000);
        try {
            driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
            Set<String> s = driver.getWindowHandles();
            Object[] arr = s.toArray();
            driver.switchTo().window(arr[1].toString());
            System.out.println(arr.length);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/a/i")).click();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profileInfo\"]/div/div/div[2]/h3")));
        } catch (TimeoutException toe) {
            System.out.println("WebElement wasn't found");
        }

    }

    public String isUserLoginSuccesValidation()
    {
        driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div/div[2]/h3")).isDisplayed();
        String username = driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div/div[2]/h3")).getText();
        return username;

    }


}
