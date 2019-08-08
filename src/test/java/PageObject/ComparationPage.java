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

    public ComparationPage(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        List<WebElement> filas = findElements(By.className("table-wrapper"));
        for (WebElement fila : filas) {
            productos.add(new ComparationProduct(fila));
        }
    }

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement pageTitle;



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
