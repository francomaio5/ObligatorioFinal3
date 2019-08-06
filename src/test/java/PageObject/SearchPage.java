package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    List<ProductObject> resultados;
    boolean encontrado;

    public SearchPage(WebDriver driver) {
        super(driver);
        resultados = new ArrayList<>();
        encontrado = false;
        List<WebElement> listadoElementos = findElements(By.className("product-item"));
        for (WebElement element : listadoElementos) {
            resultados.add(new ProductObject(element));
        }
    }

    public void addToCart(String object) {
        for (ProductObject product : resultados) {
            if (product.getName().equals(object)) {
                wait.until(ExpectedConditions.elementToBeClickable(product.getAddtoCartBttn()));
                product.addToCart();
                break;
            }
        }
    }

    public void addToWishList(String object){
        for (ProductObject product : resultados){
            if (product.getName().equals(object)){
                wait.until(ExpectedConditions.elementToBeClickable(product.getAddtoWishList()));
                product.addToWish();
                encontrado = true;
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));
                break;
            }
        }
    }

    public void addToCompareList(String object) {
        for (ProductObject product : resultados){
            if (product.getName().equals(object)){
                wait.until(ExpectedConditions.elementToBeClickable(product.getCompareBttn()));
                product.addToCompare();
                encontrado = true;
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));
                break;
            }
        }
    }


}


