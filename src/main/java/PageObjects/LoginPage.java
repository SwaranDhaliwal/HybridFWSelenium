package PageObjects;

import Utility.ExplicitWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ExplicitWait explicitWait = new ExplicitWait();

    @FindBy(how = How.XPATH, using = "//input[@id='txtUsername']")
    WebElement Username;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement Password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement LoginButton;

    public void setUsername(String username){
        explicitWait.wait(driver, Username).sendKeys(username);
//        Username.sendKeys(username);
    }
    public void setPassword(String password){
        Password.sendKeys(password);
    }

    public void setLoginButton(){
        LoginButton.click();
    }
}
