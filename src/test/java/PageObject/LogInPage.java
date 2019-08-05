package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "email")
    WebElement emailField;

    @FindBy(how = How.CLASS_NAME, using = "password")
    WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "login-button")
    WebElement loginBttn;

    public HomePage loginUser (String userID, String userPassword) {
        SeleniumUtils.clickElement(emailField, wait);
        SeleniumUtils.sendText(emailField, wait, userID);
        SeleniumUtils.clickElement(passwordField, wait);
        SeleniumUtils.sendText(passwordField, wait, userPassword);
        SeleniumUtils.clickElement(loginBttn, wait);
        return new HomePage(driver);
    }
}
