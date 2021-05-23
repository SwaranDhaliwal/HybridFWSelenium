import PageObjects.vacanciesPage;
import Utility.BaseClass;
import Utility.ConfigRead;
import Utility.ExcelRead;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;


public class AddVacancy extends BaseClass {
    ConfigRead configRead = new ConfigRead();
    String excelPath = configRead.getExcelPath();

    @Description("navigate to add vacancy page")
    @Test
    @Step("navigate to add vacancy page")
    public void addVacancy() throws IOException {
        vacanciesPage vacanciesPage = new vacanciesPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", vacanciesPage.vacanciesLink);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int rows = ExcelRead.getRowCount(excelPath, "AddVacancy");
        for (int i = 1; i <= rows; i++) {
            vacanciesPage.setAddVacancyButton();
            System.out.println(ExcelRead.getCellData(excelPath, "AddVacancy", i, 0));
            vacanciesPage.setJobTitle(Integer.parseInt(ExcelRead.getCellData(excelPath, "AddVacancy", i, 0)));
            vacanciesPage.setJobVacancyName(ExcelRead.getCellData(excelPath, "AddVacancy", i, 1));
            vacanciesPage.setHiringManager(ExcelRead.getCellData(excelPath, "AddVacancy", i, 2));
            vacanciesPage.setNumberOfPositions(ExcelRead.getCellData(excelPath, "AddVacancy", i, 3));
            vacanciesPage.setJobDescription(ExcelRead.getCellData(excelPath, "AddVacancy", i, 4));
            vacanciesPage.setSaveVacancyButton();
            vacanciesPage.vacanciesLink.click();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
