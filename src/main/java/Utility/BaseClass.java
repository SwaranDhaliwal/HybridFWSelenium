package Utility;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@Listeners(TestListeners.class)
public class BaseClass {

    ConfigRead configRead = new ConfigRead();
    String url = configRead.url();
    String chromePath = configRead.chromePath();
    String firefoxPath = configRead.firefoxPath();

    public WebDriver driver;
    public  static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public static synchronized WebDriver getDriver(){
        return tdriver.get();
    }

    @BeforeClass
    @Parameters("browser")
    public WebDriver setUp(String browserName) throws InterruptedException {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    chromePath);
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + firefoxPath);
            driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        tdriver.set(driver);
        return getDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


//    @AfterMethod
//    public void attachment(ITestResult result){
//        if (result.isSuccess()== false) {
//            screenshot(driver);
//        }
//    }
//
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] screenshot( WebDriver driverScreenshot) {
//        return ((TakesScreenshot) driverScreenshot).getScreenshotAs(OutputType.BYTES);
//    }

}
