package PageObject;

import Utils.SeleniumUtils;
import com.gargoylesoftware.htmlunit.html.ScriptElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage extends BasePage {

    @FindBy(id = "OldPassword")
    WebElement oldPasswordField;
    @FindBy(id = "NewPassword")
    WebElement newPasswordField;
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordField;
    @FindBy(className = "button-1 change-password-button")
    WebElement changePasswordBttn;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void changePasswordOk(String oldPassword, String newPassword) {
        SeleniumUtils.sendText(oldPasswordField, wait, oldPassword);
        SeleniumUtils.sendText(newPasswordField, wait, newPassword);
        SeleniumUtils.sendText(confirmNewPasswordField, wait, newPassword);
        SeleniumUtils.clickElement(changePasswordBttn, wait);
    }
}
