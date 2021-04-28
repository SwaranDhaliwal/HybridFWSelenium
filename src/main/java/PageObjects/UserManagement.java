package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagement {
    WebDriver driver;

    public UserManagement(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//b[contains(text(),'Admin')]") public WebElement admin;
    @FindBy(id = "menu_admin_UserManagement") public WebElement userManagement;
    @FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']") public WebElement user;

}
