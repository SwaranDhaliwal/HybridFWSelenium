import PageObjects.DirectoryPage;
import Utility.BaseClass;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

@Test
@Description("scroll test")
public class DirectoryPageScrollTest extends BaseClass {
    public void ScrollToParticularElement(){
        DirectoryPage directoryPage = new DirectoryPage(driver);
        directoryPage.setDirectory();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", directoryPage.gautamGanesh);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
