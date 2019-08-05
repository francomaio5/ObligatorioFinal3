package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComparationPage extends BasePage {

    List<ComparationProduct> productos;

    public ComparationPage(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        List<WebElement> filas = findElements(By.cssSelector("tbody tr"));
        for (WebElement fila : filas) {
            productos.add(new ComparationProduct(fila));
        }
    }

    public boolean itsComparing(String object1, String object2) {
        for (ComparationProduct product : productos) {
            if (product.getName().equals(object1) && product.getName().equals(object2))
                return true;
        }
        return false;
    }
}
