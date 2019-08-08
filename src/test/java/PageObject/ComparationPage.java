package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class ComparationPage extends BasePage {

    List<ComparationProduct> productos;

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement pageTitle;

    public ComparationPage(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        List<WebElement> filas = findElements(By.cssSelector("tbody tr"));
        for (WebElement fila : filas) {
            productos.add(new ComparationProduct(fila));
        }
    }

    /*public boolean itsComparing(String object1, String object2) {
        for (ComparationProduct product : productos) {
            if (product.getName().equals(object1) & product.getName().equals(object2))
                return true;
        }
        return false;
    }
*/
    //Verificar que metodo realizamos para borrar el elemento del cart
    //Aplicarlo a este método.!
    public boolean itsOnComparePage(String object) {
        for (ComparationProduct product : productos) {
            if (product.getName().equals(object));
                return true;
        }
        return false;
    }

    public boolean comparePageTitle () {
        return pageTitle.getText().contains("Compare products");
    }
}
