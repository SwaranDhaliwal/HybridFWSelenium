package PageObjects;

import Utility.ExplicitWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Recruitment {
    WebDriver driver;

    public Recruitment(WebDriver driver) {
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

    //candidates page elements
    @FindBy (css = "#menu_recruitment_viewCandidates") public WebElement candidatesButton;
    @FindBy(css = "#btnAdd") private WebElement addCandidateButton;
    @FindBy(css = "#addCandidate_firstName") private WebElement firstName;
    @FindBy(css = "#addCandidate_middleName") private WebElement middleName;
    @FindBy(css = "#addCandidate_lastName") private WebElement lastName;
    @FindBy(css = "#addCandidate_email") private WebElement email;
    @FindBy(css = "#addCandidate_contactNo") private WebElement contactNumber;
    @FindBy(css = "#addCandidate_vacancy") private WebElement vacancy;
    @FindBy(css = "#addCandidate_resume") private WebElement resume;
    @FindBy(css = "#addCandidate_keyWords") private WebElement keyWords;
    @FindBy(css = "#addCandidate_comment") private WebElement comment;
    @FindBy(css = "#addCandidate_appliedDate") private WebElement applicationDate;
    @FindBy(css = "#addCandidate_consentToKeepData") private WebElement consentCheckBox;
    @FindBy(css = "#btnSave") private WebElement saveCandidateButton;

    public void setAddCandidatesButton(){
        explicitWait.wait(driver, addCandidateButton).click();
//        addCandidateButton.click();
    }
    public void setFirstName(String fName){
        firstName.sendKeys(fName);
    }
    public void setMiddleName(String mName){
        middleName.sendKeys(mName);
    }
    public void setLastName(String lName){
        lastName.sendKeys(lName);
    }
    public void setEmail(String emailId){
        email.sendKeys(emailId);
    }
    public void setContactNumber(String number){
        contactNumber.sendKeys(number);
    }
    public void setVacancy(String vacancyName){
        Select select = new Select(vacancy);
        select.selectByVisibleText(vacancyName);
    }
    public void setResume(String resumeFileName){
        resume.sendKeys(resumeFileName);
    }
    public void setKeyWords(String keyWord){
        keyWords.sendKeys(keyWord);
    }
    public void setComment(String comments){
        comment.sendKeys(comments);
    }
    public void setApplicationDate(String appliedDate){
        applicationDate.clear();
        applicationDate.sendKeys(appliedDate);
    }
    public void setConsentCheckBox(){
        consentCheckBox.click();
    }
    public void setSaveCandidateButton(){
        saveCandidateButton.click();
    }
}
