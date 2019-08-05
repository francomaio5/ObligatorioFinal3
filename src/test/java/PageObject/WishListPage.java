package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WishListPage extends BasePage {
    List<WishListProduct> productos;

    @FindBy(id = "addtocart")
    WebElement clickCart;

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
}


