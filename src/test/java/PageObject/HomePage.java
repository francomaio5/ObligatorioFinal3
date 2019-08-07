package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement logOutIconDisplayed () {
        return driver.findElement(By.className("ico-logout"));
    }

    public boolean verificarCambioMoneda(String moneda){
        String simbolo = obtenerSimboloMoneda(moneda);
        boolean monedaOK = true;
        List<WebElement> listadoElementos = findElements(By.className("product-item"));
        List<ProductObject> listadoProductos = new ArrayList<>();
        for(WebElement element : listadoElementos){
            listadoProductos.add(new ProductObject(element));
        }
        for (ProductObject productItem : listadoProductos){
            if(!productItem.getValue().contains(simbolo))
                monedaOK = false;
        }
        return monedaOK;
    }

    public String obtenerSimboloMoneda(String moneda){
        String monedaSimbolo="";

        if(moneda.equalsIgnoreCase("USD")){
            monedaSimbolo="$";
        }else if(moneda.equalsIgnoreCase("EUR")) {
            monedaSimbolo = "Ђ";
        }
        return monedaSimbolo;

    }

}
