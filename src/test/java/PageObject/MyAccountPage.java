package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='inactive'][contains(text(),'Addresses')]")
    WebElement addresIcon;

    public void goAddress() {
        SeleniumUtils.clickElement(addresIcon, wait);
    }
}
