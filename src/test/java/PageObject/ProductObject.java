package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductObject {

    WebElement element;


    public ProductObject(WebElement main) {
        this.element = main;
    }

    public String getName(){
        return element.findElement(By.tagName("h2")).getText();
    }

    //Add to wish
    public WebElement getAddtoWishList() {
        return element.findElement(By.className("add-to-wishlist-button"));
    }
    public void addToWish() {
        element.findElement(By.className("add-to-wishlist-button")).click();
    }

    //Add to cart
    public WebElement getAddtoCartBttn() {
        return element.findElement(By.className("product-box-add-to-cart-button"));
    }
    public void addToCart(){
        element.findElement(By.className("product-box-add-to-cart-button")).click();
    }

    //Add to compare
    public WebElement getCompareBttn() {
        return element.findElement(By.className("add-to-compare-list-button"));
    }

    public void addToCompare() { element.findElement(By.className("add-to-compare-list-button")).click(); }

    public String getValue(){
        return element.findElement(By.className("actual-price")).getText();
    }
}

