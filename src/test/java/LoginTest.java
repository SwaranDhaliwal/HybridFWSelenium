import PageObjects.LoginPage;
import Utility.BaseClass;
import Utility.ExcelRead;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LoginTest extends BaseClass {

    public LoginTest() throws IOException {
    }


    @Test(dataProvider = "LoginData" )
    @Description("Login Test")
    @Step("input username amd password")
    public void loginTest(String uName, String password) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(uName);
        loginPage.setPassword(password);
        loginPage.setLoginButton();
            try {
                if (driver.findElement(By.id("menu_admin_viewAdminModule")).isDisplayed()) {
                    System.out.println("Test Passed");
                    Assert.assertTrue(true);
                }
            } catch (NoSuchElementException elementException) {
                System.out.println("Test Failed");
                Assert.assertTrue(false);
            }
        }

    @DataProvider(name="LoginData")
    public Object[][] getData() throws IOException {
        String path=System.getProperty("user.dir")+"/src/main/resources/Book1.xlsx";

        int rownum=ExcelRead.getRowCount(path, "Sheet1");
        int colcount=ExcelRead.getCellCount(path,"Sheet1",1);

        Object[][] logindata = new Object[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=ExcelRead.getCellData(path,"Sheet1", i,j);
            }
        }
        return logindata;
    }

}
