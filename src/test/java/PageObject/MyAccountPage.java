package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "save-info-button")
    WebElement saveChangesBttn;

    public void clearMail() {
        SeleniumUtils.clickElement(emailField, wait);
        SeleniumUtils.clearTextField(emailField, wait);
    }

    public void completeNewMail(String newMail) {
        SeleniumUtils.clickElement(emailField, wait);
        SeleniumUtils.sendText(emailField, wait, newMail);
    }

    public void saveChanges () {
        SeleniumUtils.clickElement(saveChangesBttn, wait);
    }
}
