package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerDetails extends PageBase{
    public CustomerDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()=' Customer details']")
    WebElement customerDetailsHeader;
    public String getCustomerDetailsHeader() {
        wait.until(e -> !fullName.getText().trim().isEmpty());
        return wait.until(ExpectedConditions.visibilityOf(customerDetailsHeader)).getText();
    }

    @FindBy(xpath = "//div[label[text()='Full Name']]//span[@id='fName']")
    WebElement fullName;
    public String getFullName() {
        return wait.until(ExpectedConditions.visibilityOf(fullName)).getText();
    }

    @FindBy(xpath = "//div[label[text()='Mobile Number']]//span[@id='phone']")
    WebElement phone;
    public String getPhone() {
        return wait.until(ExpectedConditions.visibilityOf(phone)).getText();
    }

    @FindBy(xpath = "//div[label[text()='Email']]//span[@id='email']")
    WebElement email;
    public String getEmail() {
        return wait.until(ExpectedConditions.visibilityOf(email)).getText();
    }

    @FindBy(xpath = "//div[label[text()='Specialty']]//span[@id='speciality']")
    WebElement specialty;
    public String getSpecialty() {
        return wait.until(ExpectedConditions.visibilityOf(specialty)).getText();
    }

    @FindBy(xpath = "//div[label[text()='Sub Specialties']]//span[@id='subSpecialties']")
    WebElement subSpecialty;
    public String getSubSpecialty() {
        return wait.until(ExpectedConditions.visibilityOf(subSpecialty)).getText();
    }

    @FindBy(xpath = "//div[label[text()='Area Of Practice']]//span[@id='areaOfPractice']")
    WebElement areaOfPractice;
    public String getAreaOfPractice() {
        return wait.until(ExpectedConditions.visibilityOf(areaOfPractice)).getText();
    }

    @FindBy(xpath = "//span[contains(text(),'University : ')]")
    WebElement university;
    public String getUniversity() {
        return wait.until(ExpectedConditions.visibilityOf(university)).getText().substring(13);
    }

    @FindBy(xpath = "//span[contains(text(),'Degree : ')]")
    WebElement degree;
    public String getDegree() {
        return wait.until(ExpectedConditions.visibilityOf(degree)).getText().substring(9);
    }

    @FindBy(xpath = "//div[label[text()='Hospital Polyclinics']]//span[contains(text(),'Name : ')]")
    WebElement hospitalPolyclinicsName;
    public String getHospitalPolyclinicsName() {
        return wait.until(ExpectedConditions.visibilityOf(hospitalPolyclinicsName)).getText().substring(7);
    }

    @FindBy(xpath = "//div[label[text()='Work Places']]//span[contains(text(),'Name :')]")
    WebElement workPlaceName;
    public String getWorkPlaceName() {
        return wait.until(ExpectedConditions.visibilityOf(workPlaceName)).getText().substring(7);
    }

    @FindBy(xpath = "//span[contains(text(),'Address : ')]")
    WebElement address;
    public String getWorkPlaceAddress() {
        return wait.until(ExpectedConditions.visibilityOf(address)).getText().substring(10);
    }

    @FindBy(xpath = "//i[@class='fas fa-edit']")
    WebElement editButton;
    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }
}
