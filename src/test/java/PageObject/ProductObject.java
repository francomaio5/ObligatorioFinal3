package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductObject {

    WebElement element;


    public ProductObject(WebElement main) {
        this.element = main;
    }

    public String getName(){
        return element.findElement(By.tagName("h2")).getText();
    }

    public void addToWish() {
        element.findElement(By.className("add-to-wishlist-button")).click();
    }

    public void addToCart(){
        element.findElement(By.className("product-box-add-to-cart-button")).click();

    }

    public double getPrecio() {
        String precio = element.findElement(By.className("price")).getText().substring(1, element.findElement(By.className("price")).getText().indexOf("\n"));
        return Double.valueOf(precio);
    }

    public void addToCompare() { element.findElement(By.className("add-to-compare-list-button")).click(); }
}

