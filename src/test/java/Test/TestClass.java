package Test;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestClass extends BaseTestClass {

    @Test
    public void testRegistro() {
        registerPage = homePage.goRegisterPage();
        Assert.assertTrue(registerPage.emailFieldIsDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.passFieldDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.confPasswordDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.contBttnDisplayed().isDisplayed());
        registerCompletePage = registerPage.registerNewUser("Juan", "Gonzales",
                "maildetest19@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(registerCompletePage.registerConfirm());
        Assert.assertTrue(registerCompletePage.logOutIconDisplayed().isDisplayed());
        homePage = registerCompletePage.goLogOut();
    }

    @Test
    public void checkOutEefectivo() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        //User is loged assert
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToCart("Nokia Lumia 1020");
        cartPage = searchPage.goCartPage();
        //Is on the cart page assert
        checkOutPage = cartPage.goCheckOutPage();
        //Page tittle assert
        checkOutPage.billingAddressSet("Uruguay", "Montevideo", "lala123",
                "7487", "099477811");
        checkOutPage.shippingAddressSet("Uruguay", "Montevideo", "Agraciasda",
                "3511", "094778188");
        checkOutPage.setShippingMethod("method");
        checkOutPage.setPaymentMethAndInfo("No Credit Card", "", "",
                "", "", "", "");
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        //Confirmation CheckOut assert
        homePage = checkOutConfirmationPage.goLogOut();
        driver.quit();
    }

    @Test
    public void checkOutCreditCard() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        //User is loged assert
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToCart("Nokia Lumia 1020");
        cartPage = searchPage.goCartPage();
        //Is on the cart page assert
        checkOutPage = cartPage.goCheckOutPage();
        //Page tittle assert
        checkOutPage.billingAddressSet("Uruguay", "Montevideo", "lala123",
                "7487", "099477811");
        checkOutPage.shippingAddressSet("Uruguay", "Montevideo", "Agraciasda",
                "3511", "094778188");
        checkOutPage.setShippingMethod("method");
        checkOutPage.setPaymentMethAndInfo("Credit Card", "Visa", "Raul Perez",
                "5646510", "05", "2020", "738");
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        //Confirmation CheckOut assert
        homePage = checkOutConfirmationPage.goLogOut();
        driver.quit();
    }

    @Test
    public void addToWishList() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        //User is loged assert
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToWishList("Nokia Lumia 1020");
        wishListPage = searchPage.goWishListPage();
        Assert.assertTrue(wishListPage.rigthPageTitle());
        Assert.assertTrue(wishListPage.isAtWishList("Nokia Lumia 1020"));
        homePage.goLogOut();
        driver.quit();
    }

    @Test
    public void comparteProducts() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        //Usser is loged
        searchPage = homePage.searchElement("Ultrabook");
        //Item 1 founded
        //Item 2 founded
        searchPage.addToCompareList("HP Spectre XT Pro UltraBook");
        searchPage.addToCompareList("Samsung Series 9 NP900X4C Premium Ultrabook");
        comparationPage = searchPage.goComparePage();
        //Page tittle
        //Assert.assertTrue(comparationPage.itsComparing("HP Spectre XT Pro UltraBook"));
        //Assert.assertTrue(comparationPage.itsComparing("Samsung Series 9 NP900X4C Premium Ultrabook"));
        homePage.goLogOut();
        driver.quit();
    }


    @Test
    public void badLogin() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia12");
    }

    @Test
    public void changeCurrency() {

    }

    @Test
    public void changeEmail() {

    }

    @Test
    public void clearCart() {

    }

    @Test
    public void clearWishList(){

    }

}
