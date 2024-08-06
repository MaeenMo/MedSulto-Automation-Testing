package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditDoctor extends PageBase{
    public EditDoctor(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h3[text()='Edit Doctor']")
    WebElement editDoctorHeader;

    public String editDoctorHeader() {
        return wait.until(ExpectedConditions.visibilityOf(editDoctorHeader)).getText();
    }

    // Doctor Details
    @FindBy(id = "fullName")
    WebElement fullNameField;
    @FindBy(xpath = "//div[div/h3[text()='Doctor Details']]//input[@id='mobileNumber']")
    WebElement docMobileNumberField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id ="areaOfPractice")
    WebElement areaOfPracticeField;
    @FindBy(xpath = "//div[div[text()='Select Country']]//input")
    WebElement countrySelect;

    public void editFullName(String fullName) {
        setupInput(fullNameField, fullName);
    }
    public void editMobileNumber(String mobileNumber) {
        setupInput(docMobileNumberField, mobileNumber);
    }
    public void editEmail(String email) {
        setupInput(emailField, email);
    }
    public void editAreaOfPractice(String areaOfPractice) {
        setupInput(areaOfPracticeField, areaOfPractice);
    }
    public void selectCountry(String country) {
        setupDropdown(countrySelect, country);
    }


    // Additional Settings
    @FindBy (xpath = "//ng-select[@placeholder='Select UserType']")
    WebElement userTypeSelect;
    @FindBy(xpath = "//div[div/div[text()='Select UserType']]//span[@title='Clear all']")
    WebElement clearUserType;
    @FindBy(xpath = "//div[div[text()='Select Specialty']]//input")
    WebElement specialtySelect;
    @FindBy(xpath = "//div[div[text()='Select Sub speciality']]//input")
    WebElement subSpecialtySelect;
//    @FindBy(xpath = "//div[div/div[text()='Select Sub speciality']]//span[@title='Clear all']")
//    WebElement clearAllSubSpecialtySelect;
    @FindBy(xpath = "//div[div[text()='Select Hospital Polyclinics']]//input")
    WebElement hospitalPolyclinicsSelect;
    @FindBy(xpath = "//div[div/div[text()='Select Hospital Polyclinics']]//span[@title='Clear all']")
    WebElement clearAllHospitalPolyclinicsSelect;

    public void selectUserType(String userType) {
        wait.until(ExpectedConditions.elementToBeClickable(clearUserType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userTypeSelect)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' "+ userType +" ']"))).click();
    }
    public void selectSpecialty(String specialty) {
        setupDropdown(specialtySelect, specialty);
    }
    public void selectSubSpecialty(String subSpecialty) {
        setupDropdownWithMultipleSelection(subSpecialtySelect, subSpecialty);
    }
    public void selectHospitalPolyclinics(String hospitalPolyclinics) {
        wait.until(ExpectedConditions.elementToBeClickable(clearAllHospitalPolyclinicsSelect)).click();
        setupDropdownWithMultipleSelection(hospitalPolyclinicsSelect, hospitalPolyclinics);
    }

    // Medical Image
    @FindBy(id = "projectCoverUploads")
    WebElement medicalImageUpload;

    public void uploadMedicalImage(String imagePath) {
        medicalImageUpload.sendKeys(imagePath);
    }

    // University Degrees
    @FindBy(xpath = "//div[div[text()='Select University']]//input")
    WebElement universitySelect;
    @FindBy(xpath = "//div[div[text()='Select Degree']]//input")
    WebElement degreeSelect;

    public void selectUniversity(String university) {
        setupDropdown(universitySelect, university);
    }
    public void selectDegree(String degree) {
        setupDropdown(degreeSelect, degree);
    }

    // WorkPlaces
    @FindBy(xpath = "//div[div[text()='Select City']]/div/input")
    WebElement citySelect;
    @FindBy(xpath = "//div[div[text()='Select Area']]/div/input")
    WebElement areaSelect;
    @FindBy(id = "address")
    WebElement addressField;
    @FindBy(id = "name")
    WebElement workplaceNameField;
    @FindBy(xpath = "//div[div/div/h3[text()='WorkPlaces']]//input[@id='mobileNumber']")
    WebElement workplaceMobileNumberField;

    public void selectCity(String city) {
        setupDropdown(citySelect, city);
    }
    public void selectArea(String area) {
        setupDropdown(areaSelect, area);
    }
    public void editAddress(String address) {
        setupInput(addressField, address);
    }
    public void editWorkplaceName(String workplaceName) {
        setupInput(workplaceNameField, workplaceName);
    }
    public void editWorkplaceMobileNumber(String workplaceMobileNumber) {
        setupInput(workplaceMobileNumberField, workplaceMobileNumber);
    }

    // Save Button
    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveButton;

    public void clickSave(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    // Setup Fields
    private void setupInput(WebElement input, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(input)).click();
        wait.until(ExpectedConditions.visibilityOf(input)).clear();
        wait.until(ExpectedConditions.visibilityOf(input)).sendKeys(value);
    }
    private void setupDropdown(WebElement input, String value){
        wait.until(ExpectedConditions.elementToBeClickable(input)).click();
        wait.until(ExpectedConditions.visibilityOf(input)).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' "+ value +" ']"))).click();
    }
    private void setupDropdownWithMultipleSelection(WebElement input, String value){
        wait.until(ExpectedConditions.elementToBeClickable(input)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option' and contains(text(),' " + value + " ')]"))).click();
        input.sendKeys(Keys.TAB);
    }
}
