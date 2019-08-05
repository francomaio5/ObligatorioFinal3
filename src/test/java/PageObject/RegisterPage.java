package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "FirstName")
    WebElement firstNameField;

    @FindBy(how = How.ID, using = "LastName")
    WebElement lastNameField;

    @FindBy(how = How.ID, using = "Email")
    WebElement emailField;

    @FindBy(how = How.ID, using = "Password")
    WebElement passwordField;

    @FindBy(how = How.ID, using = "ConfirmPassword")
    WebElement passwordConfirmField;

    @FindBy(how = How.ID, using = "register-button")
    WebElement registerBttn;

    public RegisterCompletePage registerNewUser (String firstName, String lastName,
                                                 String email, String password) {
        SeleniumUtils.sendText(firstNameField, wait, firstName);
        SeleniumUtils.sendText(lastNameField, wait, lastName);
        SeleniumUtils.sendText(emailField, wait, email);
        SeleniumUtils.sendText(passwordField, wait, password);
        SeleniumUtils.sendText(passwordConfirmField, wait, password);
        SeleniumUtils.clickElement(registerBttn, wait);
        return new RegisterCompletePage(driver);
    }
}
