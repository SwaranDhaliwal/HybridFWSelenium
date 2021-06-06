import PageObjects.Recruitment;
import Utility.BaseClass;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AddCandidate extends BaseClass {

    @Test
    @Description("add new candidate details")
    public void addCandidate(){
        Recruitment addCandidate = new Recruitment(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].click();", addCandidate.candidatesButton);

        addCandidate.setAddCandidatesButton();
        addCandidate.setFirstName("mike");
        addCandidate.setMiddleName("s");
        addCandidate.setLastName("taylor");
        addCandidate.setEmail("mike@gmail.com");
        addCandidate.setContactNumber("1234567890");
        addCandidate.setVacancy("Payroll Administrator");
        addCandidate.setResume("/Users/swaranjeetdhaliwal/IdeaProjects/SeleniumFramework/readme.txt");
        addCandidate.setKeyWords("payroll");
        addCandidate.setComment("abc");
        addCandidate.setApplicationDate("2021-04-23");
        addCandidate.setConsentCheckBox();
        addCandidate.setSaveCandidateButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
