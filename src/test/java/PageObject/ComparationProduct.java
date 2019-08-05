package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComparationProduct {

    WebElement element;

    public ComparationProduct(WebElement element){
        this.element = element;
    }

    public String getName(){ return element.findElement(By.cssSelector("tr:nth-child(3)")).getText(); }

    public void delete(){
        element.findElement(By.cssSelector("button[data-original-title='Remove']")).click();
    }
}
