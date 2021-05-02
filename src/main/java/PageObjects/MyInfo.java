package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo {
    WebDriver driver;

    public MyInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'My Info')]") public WebElement myInfoLink;
    @FindBy(xpath = "//a[contains(text(),'Contact Details')]") public WebElement contactDetails;
    @FindBy(css = "#btnSave") public WebElement editSaveButton;
    @FindBy(xpath = "//input[@id='contact_street1']") public WebElement street1;
    @FindBy(xpath = "//input[@id='contact_street2']") public WebElement street2;
    @FindBy(xpath = "//input[@id='contact_city']") public WebElement city;
    @FindBy(css = "#contact_province") public WebElement state;
    @FindBy(css = "#contact_emp_zipcode") public WebElement zipCode;
    @FindBy(css = "#contact_country") public WebElement country;
    @FindBy(css = "#contact_emp_hm_telephone") public WebElement homeTelephone;
    @FindBy(css = "#contact_emp_mobile") public WebElement mobile;
    @FindBy(css = "#contact_emp_work_telephone") public WebElement workPhone;
    @FindBy(css = "#contact_emp_work_email") public WebElement workEmail;
    @FindBy(css = "#contact_emp_oth_email") public WebElement otherEmail;
}
