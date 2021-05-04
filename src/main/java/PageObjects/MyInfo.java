package PageObjects;

import Utility.ExplicitWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyInfo {
    WebDriver driver;

    public MyInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ExplicitWait ew = new ExplicitWait();

    //contact details
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

    //dependents
    @FindBy(xpath = "//a[contains(text(),'Dependents')]") private WebElement dependentsLink;
    @FindBy(css = "#btnAddDependent") private WebElement addDependent;
    @FindBy(css = "#dependent_name")private WebElement dependentName;
    @FindBy(css = "#dependent_relationshipType") private WebElement relationship;
    @FindBy(css = "#dependent_dateOfBirth") private WebElement dob;
    @FindBy(xpath = "//span[contains(text(),'Next')]") private WebElement nextButton;
    @FindBy(xpath = "//span[contains(text(),'Prev')]") private WebElement previousButton;
    @FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]") private WebElement monthField;
    @FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[2]") private WebElement yearField;
    @FindBy(xpath = "//body[1]/div[3]/table[1]/tbody[1]/tr/td") private List<WebElement> dateField;
    @FindBy(xpath = "//input[@id='btnSaveDependent']") private WebElement saveDependent;


    public void setMyInfoLink(){
        myInfoLink.click();
    }

    public void setDependentsLink(){
        ew.wait(driver, dependentsLink).click();
    }

    public void setAddDependent(){
        ew.wait(driver, addDependent).click();
    }

    public void setDependentName(String name){
        ew.wait(driver, dependentName).sendKeys(name);
    }

    public void setRelationship(String relation){
        Select select = new Select(ew.wait(driver, relationship));
        select.selectByVisibleText(relation);
    }

    public void setDob(String year, String month, String date){
        ew.wait(driver, dob).click();
        Select selectYear = new Select(yearField);
        Select selectMonth = new Select(monthField);
        selectYear.selectByVisibleText(year);
        selectMonth.selectByVisibleText(month);
        for(WebElement item: dateField){
            if(item.getText().equals(date)){
                item.click();
            }
        }

    }

    public void setSaveDependent(){
        ew.wait(driver, saveDependent).click();
    }
}
