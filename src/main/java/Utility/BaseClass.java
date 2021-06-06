package Utility;
;
import PageObjects.LoginPage;
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
    String username = configRead.getUserName();
    String password = configRead.getPassword();

    public WebDriver driver;

    public  static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public static synchronized WebDriver getDriver(){
        return tdriver.get();
    }

    @BeforeClass
    @Parameters("browser")
    public WebDriver setUp(String browserName) {
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

    @BeforeClass
    public void setupLogin(){
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
        lp.setLoginButton();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
