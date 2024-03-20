package Action;

import Base.base;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class action extends base {
    public void implicitWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
