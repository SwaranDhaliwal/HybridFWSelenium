package PageObjects;

import Utility.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class vacanciesPage {
    WebDriver driver;

    public vacanciesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ExplicitWait explicitWait = new ExplicitWait();

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    public WebElement recruitmentLink;

    //add new vacancy
    @FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
    public WebElement vacanciesLink;
    @FindBy(css = "#btnAdd")
    private WebElement addVacancyButton;
    @FindBy(css = "#addJobVacancy_jobTitle")
    private WebElement jobTitle;
    @FindBy(css = "#addJobVacancy_name")
    private WebElement jobVacancyName;
    @FindBy(css = "#addJobVacancy_hiringManager")
    private WebElement hiringManager;
    @FindBy(css = "#addJobVacancy_noOfPositions")
    private WebElement numberOfPositions;
    @FindBy(css = "#addJobVacancy_description")
    private WebElement jobDescription;
    @FindBy(css = "#btnSave")
    private WebElement saveVacancyButton;

    //search job title
    @FindBy(xpath = "//select[@id='vacancySearch_jobTitle']")
    public WebElement jobTitleDropDown;

    public void setAddVacancyButton() {
        addVacancyButton.click();
    }

    public void setJobTitle(int indexNumber) {
        Select select = new Select(jobTitle);
        select.selectByIndex(indexNumber);
    }

    public void setJobVacancyName(String jobVacancyNameString) {
        explicitWait.wait(driver, jobVacancyName).sendKeys(jobVacancyNameString);
//       jobVacancyName.sendKeys(jobVacancyNameString);
    }

    public void setHiringManager(String hiringManagerName) {
        hiringManager.sendKeys(hiringManagerName);
    }
    public void setNumberOfPositions(String numberOfPositionsString){
        numberOfPositions.sendKeys(numberOfPositionsString);
    }
    public void setJobDescription(String jobDescriptionString){
        jobDescription.sendKeys(jobDescriptionString);
    }
    public void setSaveVacancyButton(){
        saveVacancyButton.click();
    }
}
