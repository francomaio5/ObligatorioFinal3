package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListProduct {
    WebElement element;

    public WishListProduct(WebElement element){
        this.element = element;
    }

    public String getName(){ return element.findElement(By.className("product")).getText();
    }

//    public void addToCart(){ element.findElement(By.id("addtocart")).click(); }

    public void delete(){
        element.findElement(By.name("removefromcart")).click();
    }

}
