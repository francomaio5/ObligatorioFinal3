package Test;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestClass extends BaseTestClass {

    @Test
    public void testRegistro(Method method, String nombre, String apellido){
        //Reporte
//        extentTest = extentReports.createTest(method.getName());
//        extentTest.log(Status.INFO, "Registrando al usuario " + nombre + apellido);
        //Caso de Prueba
        registerPage = homePage.goRegisterPage();
        registerCompletePage = registerPage.registerNewUser("Juan", "Gonzales",
                "maildetest10@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(registerCompletePage.registerConfirm());
        Assert.assertTrue(registerCompletePage.logOutIconDisplayed().isDisplayed());
        homePage = registerCompletePage.goLogOut();
    }

    @Test
    public void checkOutWithoutCC(String object, Method method) {
        //Reporte
//        extentTest = extentReports.createTest(method.getName());
//        extentTest.log(Status.INFO, "Buscando articulo " + object + "pagandolo con efectivo");
        //Caso de Prueba
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Nokia");
        searchPage.addToCart("Nokia");
        cartPage = searchPage.goCartPage();
        checkOutPage = cartPage.goCheckOutPage();
        checkOutConfirmationPage = checkOutPage.doCheckOut("Tata", "Uruguay", "Montevideo",
           "Zapican 2507", "Santa Fe", "2507", "094778188",
            "094778188", "Next Day Air", "Not Credit Card",
                "Master card", "Mario Perez", "15341846135",
                "05", "2020", "758");
        Assert.assertTrue(checkOutConfirmationPage.isOrderConfirmed());
        homePage = checkOutConfirmationPage.goLogOut();
    }

    @Test
    public void checkOutWithCC(String object, Method method) {
        //Reporte
//        extentTest = extentReports.createTest(method.getName());
//        extentTest.log(Status.INFO, "Buscando articulo " + object + "pagandolo con Tarjeta de Crédito");
        //Caso de Prueba
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Nokia");
        searchPage.addToCart("Nokia");
        cartPage = searchPage.goCartPage();
        checkOutPage = cartPage.goCheckOutPage();
        checkOutConfirmationPage = checkOutPage.doCheckOut("Tata", "Uruguay", "Montevideo",
                "Zapican 2507", "Santa Fe", "2507", "094778188",
                "094778188", "Next Day Air", "Credit Card",
                "Master card", "Mario Perez", "15341846135",
                "05", "2020", "758");
        Assert.assertTrue(checkOutConfirmationPage.isOrderConfirmed());
        homePage = checkOutConfirmationPage.goLogOut();
    }

    @Test
    public void addToWishList() {
//        //Reporte
//        extentTest = extentReports.createTest(method.getName());
//        extentTest.log(Status.INFO, "Buscando articulo " + object + "y agregandolo a la Wish List");
        //Casos de Pruebas
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        searchPage.addToWishList("Nokia");
        wishListPage = searchPage.goWishListPage();
        Assert.assertTrue(wishListPage.isAtWishList("Nokia Lumia 1020"));
        homePage.goLogOut();
    }

    @Test
    public void comparteProducts(Method method, String object1, String object2){
        //Reporte
//        extentTest = extentReports.createTest(method.getName());
//        extentTest.log(Status.INFO, "Comparando " + object1 + object2);
        //Casos de Pruebas
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Nokia");
        searchPage.addToCompareList("Nokia");
        searchPage.addToCompareList("Nokia");

    }
}
