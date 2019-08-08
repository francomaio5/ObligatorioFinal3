package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement pageTitle;


    public WebElement logOutIconDisplayed() {
        return driver.findElement(By.className("ico-logout"));
    }

    public WebElement userIsLogedOut() {
        return driver.findElement(By.className("ico-login"));
    }

    public boolean verificarCambioMoneda(String moneda) {
        String simbolo = obtenerSimboloMoneda(moneda);
        boolean monedaOK = true;
        List<WebElement> listadoElementos = findElements(By.className("product-item"));
        List<ProductObject> listadoProductos = new ArrayList<>();
        for (WebElement element : listadoElementos) {
            listadoProductos.add(new ProductObject(element));
        }
        for (ProductObject productItem : listadoProductos) {
            if (!productItem.getValue().contains(simbolo))
                monedaOK = false;
        }
        return monedaOK;
    }

    public String obtenerSimboloMoneda(String moneda) {
        String monedaSimbolo = "";

        if (moneda.equalsIgnoreCase("USD")) {
            monedaSimbolo = "$";
        } else if (moneda.equalsIgnoreCase("EUR")) {
            monedaSimbolo = "Ђ";
        }
        return monedaSimbolo;

    }

    public boolean homePageTittle() {
        return pageTitle.getText().contains("Welcome to our store");
    }


}
