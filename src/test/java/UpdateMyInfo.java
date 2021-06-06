import PageObjects.LoginPage;
import PageObjects.MyInfo;
import Utility.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class UpdateMyInfo extends BaseClass {
    LoginPage lp;
    MyInfo updateInfo;

    @Test
    @Description("Update contact details")
    @Step("input data and click save button")
    public void contactDetailsUpdate(){
        updateInfo = new MyInfo(driver);

        updateInfo.myInfoLink.click();
        updateInfo.contactDetails.click();
        updateInfo.editSaveButton.click();


        updateInfo.street1.sendKeys("abc1");
        updateInfo.street2.sendKeys("abc2");
        updateInfo.city.sendKeys("london");
        updateInfo.state.sendKeys("ontario");
        updateInfo.zipCode.sendKeys("151999");

        Select selectCountry = new Select(updateInfo.country);
        selectCountry.selectByIndex(4);

        updateInfo.homeTelephone.sendKeys("1234567890");
        updateInfo.mobile.sendKeys("0987654321");
        updateInfo.workPhone.clear();
        updateInfo.workPhone.sendKeys("111111111");
        updateInfo.workEmail.clear();
        updateInfo.workEmail.sendKeys("abc@gmail.com");
        updateInfo.otherEmail.sendKeys("other@gmail.com");

        updateInfo.editSaveButton.click();

        Assert.assertTrue(driver.getPageSource().contains("Successfully Saved"));
    }

    @Test
    @Description("add dependent")
    @Step("add details about dependent")
    public void addDependent() throws InterruptedException {
        updateInfo = new MyInfo(driver);
         boolean result = false;

        updateInfo.setMyInfoLink();
        updateInfo.setDependentsLink();
        updateInfo.setAddDependent();
        updateInfo.setDependentName("ram");
        updateInfo.setRelationship("Child");
        updateInfo.setDob("1989", "Dec", "15");
        updateInfo.setSaveDependent();

        Thread.sleep(5000);

        List<WebElement> expectedOutput = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        for (WebElement item : expectedOutput){
            System.out.println(item.getText());
            if (item.getText().equals("ram")){
            result = true;
            break;
            }
        }
        Assert.assertTrue(result);
    }
}
