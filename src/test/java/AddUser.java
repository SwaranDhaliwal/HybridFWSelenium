import PageObjects.LoginPage;
import PageObjects.UserManagement;
import Utility.BaseClass;
import io.qameta.allure.Description;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddUser extends BaseClass {

    @Test
    @Description("mouse hover using action class to add users page")
    public void addNewUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        UserManagement userManagement = new UserManagement(driver);
        Actions actions = new Actions(driver);
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        actions.moveToElement(userManagement.admin).moveToElement(userManagement.userManagement).moveToElement(userManagement.user).build().perform();
        userManagement.user.click();
    }
}
