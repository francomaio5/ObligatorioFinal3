package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    List<CartProduct> productos;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "termsofservice")
    WebElement termsofservCheckBox;

    @FindBy(id = "checkout")
    WebElement checkOutBttn;

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement pageTitle;

    @FindBy(name = "updatecart")
    WebElement updateCartBttn;

    public CheckOutPage goCheckOutPage() {
        SeleniumUtils.clickElement(termsofservCheckBox, wait);
        SeleniumUtils.clickElement(checkOutBttn, wait);
        return new CheckOutPage(driver);
    }

    public boolean cartPageTitle() {
        return pageTitle.getText().contains("Shopping cart");
    }

    public void deleteItem(String object) {
        for (CartProduct product : productos) {
            if (product.getName().equals(object)) {
                product.delete();
                break;
            }
        }
    }

    public void updateCart() {
        SeleniumUtils.clickElement(updateCartBttn, wait);
    }

    public boolean isCartEmpty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='no-data']")));
        WebElement wishListStatus = driver.findElement(By.xpath("//div[@class='no-data']"));
        return wishListStatus.getText().contains("Your Shopping Cart is empty!");
    }
}
