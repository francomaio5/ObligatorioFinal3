package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "termsofservice")
    WebElement termsofservCheckBox;

    @FindBy(id = "checkout")
    WebElement checkOutBttn;

    public CheckOutPage goCheckOutPage (){
        SeleniumUtils.clickElement(termsofservCheckBox, wait);
        SeleniumUtils.clickElement(checkOutBttn, wait);
        return new CheckOutPage(driver);
    }

//    public void clearCart(String object) {
//        for (CartObject product : resultados) {
//            if(product.getName().equals(object)) {
//                wait.until(ExpectedConditions.elementToBeClickable(product.getClearBttn()));
//                product.clearCart();
//                encontrado = true;
//                break;
//            }
//        }
//    } -> Falta crear CartObject y probarlo
}
