package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrencyChange {

    WebDriver driver;
    WebDriverWait wait;

    public CurrencyChange(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "customerCurrency")
    WebElement currencySelect;

    public void currencyChose (String moneda) {
        SeleniumUtils.clickElement(currencySelect, wait);
        if(moneda.equalsIgnoreCase("Dolar")){
            SeleniumUtils.selectByText(currencySelect, "US Dollar", wait);
        } else if (moneda.equalsIgnoreCase("Euro")){
            SeleniumUtils.selectByText(currencySelect, "Euro", wait);
        }
    }

}
