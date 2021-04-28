package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Vacancies {
    WebDriver driver;

    public Vacancies(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]") public WebElement recruitmentLink;
    @FindBy(css = "#menu_recruitment_viewJobVacancy") public WebElement vacanciesLink;
    @FindBy(xpath = "//select[@id='vacancySearch_jobTitle']") public WebElement jobTitleDropDown;

    public void setJobTitle(int indexnumber){
        Select select = new Select(jobTitleDropDown);
        select.selectByIndex(indexnumber);
    }
}
