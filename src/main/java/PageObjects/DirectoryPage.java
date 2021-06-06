package PageObjects;

import Utility.ExplicitWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectoryPage {
    ExplicitWait explicitWait = new ExplicitWait();
    WebDriver driver;
    public DirectoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#menu_directory_viewDirectory") private WebElement directory;
    @FindBy(xpath = "//b[contains(text(),'Goutam Ganesh')]") public WebElement gautamGanesh;

    public void setDirectory(){
        explicitWait.wait(driver, directory).click();
    }
}
