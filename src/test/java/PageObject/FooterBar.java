package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterBar {

    WebDriver driver;
    WebDriverWait wait;

    public FooterBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Compare products list')]")
    WebElement compareBttn;

    public ComparationPage goComparationPage () {
        SeleniumUtils.clickElement(compareBttn, wait);
        return new ComparationPage(driver);
    }
}
