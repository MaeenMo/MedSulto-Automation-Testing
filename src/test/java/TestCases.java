import Pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCases extends TestBase {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("SPOCAgent1@evapharma.com");
        loginPage.enterPassword("Eva-12345");
        loginPage.clickSignIn();

    }

    @Test(dependsOnMethods = {"loginTest"})
    public void addDoctorTest() {
        MedsultoDoctors medsultoDoctors = new MedsultoDoctors(driver);
        assertEquals("Medsulto Doctors List", medsultoDoctors.getHomePageHeader());
        medsultoDoctors.clickAddDoctor();
        AddDoctor addDoctor = new AddDoctor(driver);
        assertEquals("Add Doctor",addDoctor.addDoctorHeader());
        addDoctor.enterFullName("Dr. Test");
        addDoctor.enterMobileNumber("01010101010");
        addDoctor.enterEmail("automation@selenium.com");
        addDoctor.enterAreaOfPractice("Dermatology");
        addDoctor.selectCountry("Egypt");
        addDoctor.selectSpecialty("Dermatology");
        addDoctor.selectSubSpecialty("Adult dermatology");
        addDoctor.selectHospitalPolyclinics("Al Safwa Medical Center");
        addDoctor.uploadMedicalImage("C:\\Users\\maeen\\Pictures\\Screenshot\\Screenshot 2024-07-24 094202.png");
        addDoctor.selectUniversity("Ain Shams University");
        addDoctor.selectDegree("Bachelor");
        addDoctor.selectCity("Cairo");
        addDoctor.selectArea("El-Maddi");
        addDoctor.enterAddress("Test Address");
        addDoctor.enterWorkplaceName("Test Clinic");
        addDoctor.enterWorkplaceMobileNumber("0212345678");
//        addDoctor.clickSave();
//        assertEquals("Customer added successfully",medsultoDoctors.getSuccessMessage());
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void searchDoctorTest() {
        MedsultoDoctors medsultoDoctors = new MedsultoDoctors(driver);
        assertEquals("Medsulto Doctors List", medsultoDoctors.getHomePageHeader());
        medsultoDoctors.searchDoctor("Dr. Test");
        medsultoDoctors.selectSearchCriteria("Full Name");
        medsultoDoctors.clickSearch();
        medsultoDoctors.viewDoctor("Dr. Test", "01010101010");
    }

    @Test(dependsOnMethods = {"searchDoctorTest"})
    public void viewDoctorTest() {
        CustomerDetails customerDetails = new CustomerDetails(driver);
        assertEquals("Customer details", customerDetails.getCustomerDetailsHeader());
        assertEquals("Dr. Test", customerDetails.getFullName());
        assertEquals("01010101010", customerDetails.getPhone());
        assertEquals("automation@selenium.com", customerDetails.getEmail());
        assertEquals("Dermatology", customerDetails.getSpecialty());
        assertEquals("Adult dermatology", customerDetails.getSubSpecialty());
        assertEquals("Dermatology", customerDetails.getAreaOfPractice());
        assertEquals("Ain Shams University", customerDetails.getUniversity());
        assertEquals("Bachelor", customerDetails.getDegree());
        assertEquals("Al Safwa Medical Center", customerDetails.getHospitalPolyclinicsName());
        assertEquals("Test Clinic", customerDetails.getWorkPlaceName());
        assertEquals("Test Address", customerDetails.getWorkPlaceAddress());

    }

    @Test(dependsOnMethods = {"viewDoctorTest"})
    public void editDoctorTest() {
        new CustomerDetails(driver).clickEdit();
        EditDoctor editDoctor = new EditDoctor(driver);
        assertEquals("Edit Doctor", editDoctor.editDoctorHeader());
        editDoctor.editFullName("Dr. Test Edited");
        editDoctor.editMobileNumber("01212121212");
        editDoctor.editEmail("automation@selenium.edited");
        editDoctor.editAreaOfPractice("Cardiology");
        editDoctor.selectCountry("Egypt");
        editDoctor.selectUserType("Non_CRM");
        editDoctor.selectSpecialty("Cardiology");
        editDoctor.selectSubSpecialty("Adult Cardiology");
        editDoctor.selectHospitalPolyclinics("57357 Hospital");
        editDoctor.uploadMedicalImage("C:\\Users\\maeen\\Pictures\\Screenshot\\Screenshot 2024-07-24 094202.png");
        editDoctor.selectUniversity("Alexandria University");
        editDoctor.selectDegree("Master");
        editDoctor.selectCity("Alexandria");
        editDoctor.selectArea("El-Montazah");
        editDoctor.editAddress("Edited Address");
        editDoctor.editWorkplaceName("Edited Clinic");
        editDoctor.editWorkplaceMobileNumber("0212345678");
//        editDoctor.clickSave();
//        assertEquals("Customer edited successfully",new MedsultoDoctors(driver).getSuccessMessage());
    }
}
