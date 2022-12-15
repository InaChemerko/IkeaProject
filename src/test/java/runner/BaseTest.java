package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.edgedriver().setup();
    }
    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new EdgeDriver();
        driver.get("https://www.ikea.com/us/en");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

//    @AfterMethod
//    public void CloseDriver() {
//        driver.quit();
//    }
}
