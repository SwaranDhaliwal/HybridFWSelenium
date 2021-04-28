package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

    public WebElement wait(WebDriver driver, WebElement elementLocator) {
        WebDriverWait ecWait = new WebDriverWait(driver, 30);
        return ecWait.until(ExpectedConditions.visibilityOf(elementLocator));
    }
}
