package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "email")
    WebElement emailField;

    @FindBy(how = How.CLASS_NAME, using = "password")
    WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "login-button")
    WebElement loginBttn;

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement pageTitle;

    public HomePage loginUser(String userID, String userPassword) {
        SeleniumUtils.clickElement(emailField, wait);
        SeleniumUtils.sendText(emailField, wait, userID);
        SeleniumUtils.clickElement(passwordField, wait);
        SeleniumUtils.sendText(passwordField, wait, userPassword);
        SeleniumUtils.clickElement(loginBttn, wait);
        return new HomePage(driver);
    }

    public void clearMail() {
        SeleniumUtils.clickElement(emailField, wait);
        SeleniumUtils.clearTextField(emailField, wait);
    }

    public WebElement mailField() {
        return emailField;
    }

    public WebElement passField() {
        return passwordField;
    }

    public WebElement logBttn() {
        return loginBttn;
    }

    public boolean wrongLogIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message-error")));
        WebElement orderConfirmation = driver.findElement(By.className("message-error"));
        return orderConfirmation.getText().contains("Login was unsuccessful. Please correct the errors and try again.");
    }
    public boolean passCleared () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("password")));
        WebElement passClear = driver.findElement(By.className("password"));
        return passClear.getAttribute("value").isEmpty();
    }

    public boolean logInPageTittle() {
        return pageTitle.getText().contains("Welcome, Please Sign In!");
    }
}
