package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartProduct {

    WebElement element;

    public CartProduct(WebElement element){
        this.element = element;
    }

    public String getName(){ return element.findElement(By.className("product")).getText();
    }
    public void delete(){
        element.findElement(By.id("removefromcart109925")).click();
    }
}
