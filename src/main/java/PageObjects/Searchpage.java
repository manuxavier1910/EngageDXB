package PageObjects;

import Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class Searchpage extends base {

    public Searchpage()
    {
        PageFactory.initElements(driver, this);
    }

    public void selectValueFromDropdown(String value, String companyName)
    {
        WebElement w1 = driver.findElement(By.xpath("//*[@id=\"searchType\"]"));
        Select s = new Select(w1);
        s.selectByVisibleText(value);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]")).sendKeys(companyName);
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div/div[2]/div/div/form/button")).click();

    }

    public void searchForElement(String value)
    {
        WebElement w1 = driver.findElement(By.xpath("//*[@id=\"data\"]/div[1]/table"));
        List<WebElement> l1 = w1.findElements(By.tagName("tr"));
        for(WebElement w2 : l1)
        {
            String actualValue = w2.getText();
            System.out.println(actualValue);
            if(actualValue.equalsIgnoreCase(value))
            {
                driver.findElement(By.xpath("//*[@id=\"data\"]/div[1]/table/tbody/tr[1]/td[3]/a")).click();
            }
        }

    }

    public String validatePage()
    {
        String page = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/div[1]/div/div[1]/div[3]/h3")).getText();
        return page;
    }

}
