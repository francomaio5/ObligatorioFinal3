package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBar {

    WebDriver driver;
    WebDriverWait wait;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "search-box-text")
    WebElement searchBox;

    @FindBy(className = "search-box-button")
    WebElement searchBoxBttn;

    public SearchPage buscarObjeto (String objeto){
        SeleniumUtils.clickElement(searchBox, wait);
        SeleniumUtils.sendText(searchBox, wait, objeto);
        SeleniumUtils.clickElement(searchBoxBttn, wait);
        return new SearchPage (driver);

    }
}
