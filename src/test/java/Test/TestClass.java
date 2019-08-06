package Test;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestClass extends BaseTestClass {

    @Test
    public void testRegistro(){
        registerPage = homePage.goRegisterPage();
        registerCompletePage = registerPage.registerNewUser("Juan", "Gonzales",
                "maildetest10@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(registerCompletePage.registerConfirm());
        Assert.assertTrue(registerCompletePage.logOutIconDisplayed().isDisplayed());
        homePage = registerCompletePage.goLogOut();
    }

    @Test
    public void checkOutEefectivo() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        searchPage.addToCart("Nokia Lumia 1020");
        cartPage = searchPage.goCartPage();
        checkOutPage = cartPage.goCheckOutPage();
        checkOutPage.billingAddressSet("Uruguay","Montevideo", "lala123",
                "7487", "099477811");
        checkOutPage.shippingAddressSet("Uruguay","Montevideo","Agraciasda",
                "3511", "094778188");
        checkOutPage.setShippingMethod("method");
        checkOutPage.setPaymentMethAndInfo("No Credit Card", "", "",
                "","", "", "");
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        homePage = checkOutConfirmationPage.goLogOut();
        driver.quit();
    }

    @Test
    public void checkOutCreditCard() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        searchPage.addToCart("Nokia Lumia 1020");
        cartPage = searchPage.goCartPage();
        checkOutPage = cartPage.goCheckOutPage();
        checkOutPage.billingAddressSet("Uruguay","Montevideo", "lala123",
                "7487", "099477811");
        checkOutPage.shippingAddressSet("Uruguay","Montevideo","Agraciasda",
                "3511", "094778188");
        checkOutPage.setShippingMethod("method");
        checkOutPage.setPaymentMethAndInfo("Credit Card", "Visa", "Raul Perez",
                "5646510","05", "2020", "738");
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        homePage = checkOutConfirmationPage.goLogOut();
        driver.quit();
    }

    @Test
    public void addToWishList() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        searchPage.addToWishList("Nokia Lumia 1020");
        wishListPage = searchPage.goWishListPage();
        Assert.assertTrue(wishListPage.isAtWishList("Nokia Lumia 1020"));
        homePage.goLogOut();
        driver.quit();
    }

    @Test
    public void comparteProducts(){
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("Ultrabook");
        searchPage.addToCompareList("HP Spectre XT Pro UltraBook");
        searchPage.addToCompareList("Samsung Series 9 NP900X4C Premium Ultrabook");
        comparationPage = searchPage.goComparePage();
    }

    @Test
    public void badLogin() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia12");
    }

    @Test
    public void changeCurrency() {

    }
}
