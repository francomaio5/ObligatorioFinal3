package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class WishListPage extends BasePage {
    List<WishListProduct> productos;

    @FindBy(id = "addtocart")
    WebElement clickCart;

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement pageTitle;

    @FindBy(name = "updatecart")
    WebElement updateCartBttn;

    public WishListPage(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        List<WebElement> filas = findElements(By.cssSelector("tbody tr"));
        for (WebElement fila : filas) {
            productos.add(new WishListProduct(fila));
        }
    }

    public boolean isAtWishList(String object) {
        for (WishListProduct product : productos) {
            if (product.getName().equals(object))
                return true;
        }
        return false;
    }

    public void deleteItem(String object) {
        for (WishListProduct product : productos) {
            if (product.getName().equals(object)) {
                product.delete();
                break;
            }
        }
    }

    public boolean wishListPageTitle () {
        return pageTitle.getText().contains("Wishlist");
    }

    public void updateWishList() {
        SeleniumUtils.clickElement(updateCartBttn, wait);
    }
}


