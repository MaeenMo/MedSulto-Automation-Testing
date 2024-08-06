package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement emailField;
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    @FindBy(xpath="//input[@id=\"password\" and @name=\"password\"]")
    WebElement passwordField;
    public void enterPassword(String pass) {
        passwordField.sendKeys(pass);
    }

//    @FindBy(xpath="//*[@type=\"submit\"]")
    @FindBy(xpath="//button[@type=\"submit\"]")
    WebElement signInButton;
    public void clickSignIn() {
        signInButton.click();
    }
}
