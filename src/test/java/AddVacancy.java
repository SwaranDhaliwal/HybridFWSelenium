import PageObjects.LoginPage;
import PageObjects.Vacancies;
import Utility.BaseClass;
import io.qameta.allure.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddVacancy extends BaseClass {

    @Description("navigate to add vacancy page")
    @Test
    @Step("navigate to add vacancy page")
    public void addVacancy(){
        Vacancies vacancies = new Vacancies(driver);
        LoginPage loginPage = new LoginPage(driver);
        Actions actions = new Actions(driver);

        loginPage.setUsername("Admin1");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        Assert.assertTrue(false);

        actions.moveToElement(vacancies.recruitmentLink).moveToElement(vacancies.vacanciesLink).build().perform();
        vacancies.vacanciesLink.click();
        vacancies.setJobTitle(5);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
