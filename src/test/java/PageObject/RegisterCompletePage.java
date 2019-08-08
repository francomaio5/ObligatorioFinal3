package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterCompletePage extends BasePage {

    public RegisterCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean registerConfirm() {
        return driver.findElement(By.className("page-body")).getText().contains("Your registration completed");
    }

    public WebElement logOutIconDisplayed () {
        return driver.findElement(By.className("ico-logout"));
    }
}
