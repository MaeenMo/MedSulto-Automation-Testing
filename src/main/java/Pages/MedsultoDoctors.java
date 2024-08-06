package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MedsultoDoctors extends PageBase {

    public MedsultoDoctors(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='Medsulto Doctors List']")
    WebElement homePageHeader;

    public String getHomePageHeader() {
        return wait.until(ExpectedConditions.visibilityOf(homePageHeader)).getText();
    }

    @FindBy(xpath = "//div[@id='toast-container']//span[contains(text(),'Customer') and contains(text(),'successfully')]")
    WebElement successMessage;

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
    }

    @FindBy(xpath = "//button[text()='Add Doctor']")
    WebElement addDoctorButton;

    public void clickAddDoctor() {
        addDoctorButton.click();
    }

    @FindBy(id = "src_txt")
    WebElement searchDoctorField;

    public void searchDoctor(String doctorName) {
        wait.until(ExpectedConditions.visibilityOf(searchDoctorField)).click();
        searchDoctorField.sendKeys(doctorName);
    }

    @FindBy(id = "searchCriteria")
    WebElement searchCriteria;

    public void selectSearchCriteria(String criteria) {
        Select selectSearchCriteria = new Select(searchCriteria);
        selectSearchCriteria.selectByVisibleText(criteria);
    }

    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchButton;

    public void clickSearch() {
        searchButton.click();
    }

    public void viewDoctor(String doctorName, String doctorMobile) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//datatable-body-row[div//i[contains(@class,'fa-trash')] and div//span[text()='" + doctorName + "'] and div//span[text()='" + doctorMobile + "']]//span[text()='" + doctorName + "']"))).click();
    }
}
