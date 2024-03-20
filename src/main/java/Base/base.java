package Base;

import Action.action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {

    static Properties prop;
    public static WebDriver driver;


    @BeforeTest
    public void loadConfig()
    {
        try
        {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void launchApp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe" );
            driver= new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe" );
            driver = new FirefoxDriver();
            Thread.sleep(10000);
        }
        else if(browserName.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver= new EdgeDriver();
            Thread.sleep(10000);
        }
        action a = new action();
        a.implicitWait(driver, 10);
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

}
