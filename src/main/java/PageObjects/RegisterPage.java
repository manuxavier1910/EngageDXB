package PageObjects;

import Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends base {

    public RegisterPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogin() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"one-page-nav\"]/li[7]/a")).click();
    }

    public void clickOnRegister() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[3]/a")).click();
    }

    public String validateRegisterUrl()
    {
        String actualRegisterUrl = driver.getCurrentUrl();
        return actualRegisterUrl;
    }

    public boolean validateLogo()
    {
        boolean flag = false;
        flag = driver.findElement(By.xpath("/html/body/nav/div/div[1]/div[2]/a/img")).isDisplayed();
        return flag;
    }

    public String validateHeader()
    {
        String headerName = "";
        headerName = driver.findElement(By.xpath("//*[@id=\"first-screen\"]/div[1]/div/h3")).getText();
        return headerName;
    }

    public String fillForm1(String fname, String lname) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(fname);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lname);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"firstNext\"]/i")).click();
        Thread.sleep(5000);
        String successText = driver.findElement(By.xpath("//*[@id=\"second-screen\"]/div[1]/div/h3")).getText();
        return successText;
    }

    public void fillForm2(String email, String password) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"EmailID\"]")).sendKeys(email);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"termsOfUses\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"seondNext\"]/i")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"btnSkip\"]")).click();
        Thread.sleep(5000);

    }

//    public boolean userHomeValidation()
//    {
//        boolean flag = false;
//        flag =
//    }

}
