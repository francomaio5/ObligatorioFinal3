package Test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestClass extends BaseTestClass {

    @Test
    public void testRegistro() {
        registerPage = homePage.goRegisterPage();
        Assert.assertTrue(registerPage.emailFieldIsDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.passFieldDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.confPasswordDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.contBttnDisplayed().isDisplayed());
        registerCompletePage = registerPage.registerNewUser("Juan", "Gonzales",
                "maildetest2@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(registerCompletePage.registerConfirm());
        Assert.assertTrue(registerCompletePage.logOutIconDisplayed().isDisplayed());
        homePage = registerCompletePage.goLogOut();
    }

    @Test
    public void checkOutEefectivo() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToCart("Nokia Lumia 1020");
        cartPage = searchPage.goCartPage();
        Assert.assertTrue(cartPage.cartPageTitle());
        checkOutPage = cartPage.goCheckOutPage();
        Assert.assertTrue(checkOutPage.checkOutPageTitle());
        checkOutPage.billingAddressSet("Uruguay", "Montevideo", "lala123",
                "7487", "099477811");
        checkOutPage.shippingAddressSet("Uruguay", "Montevideo", "Agraciasda",
                "3511", "094778188");
        checkOutPage.setShippingMethod("method");
        checkOutPage.setPaymentMethAndInfo("No Credit Card", "", "",
                "", "", "", "");
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        Assert.assertTrue(checkOutConfirmationPage.isOrderConfirmed());
        homePage = checkOutConfirmationPage.goLogOut();
    }

    @Test
    public void addToWishList() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest888@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToWishList("Nokia Lumia 1020");
        wishListPage = searchPage.goWishListPage();
        Assert.assertTrue(wishListPage.wishListPageTitle());
        Assert.assertTrue(wishListPage.isAtWishList("Nokia Lumia 1020"));
        homePage.goLogOut();
    }

    @Test
    public void comparteProducts() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest888@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement("Ultrabook");
        Assert.assertTrue(searchPage.objetoEncontrado("HP Spectre XT Pro UltraBook"));
        Assert.assertTrue(searchPage.objetoEncontrado("Samsung Series 9 NP900X4C Premium Ultrabook"));
        searchPage.addToCompareList("HP Spectre XT Pro UltraBook");
        searchPage.addToCompareList("Samsung Series 9 NP900X4C Premium Ultrabook");
        comparationPage = searchPage.goComparePage();
        Assert.assertTrue(comparationPage.comparePageTitle());
        //Assert.assertTrue(comparationPage.itsComparing("HP Spectre XT Pro UltraBook"));
        //Assert.assertTrue(comparationPage.itsComparing("Samsung Series 9 NP900X4C Premium Ultrabook"));
        homePage.goLogOut();
    }

    @Test
    public void checkOutCreditCard() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToCart("Nokia Lumia 1020");
        cartPage = searchPage.goCartPage();
        Assert.assertTrue(cartPage.cartPageTitle());
        checkOutPage = cartPage.goCheckOutPage();
        Assert.assertTrue(checkOutPage.checkOutPageTitle());
        checkOutPage.billingAddressSet("Uruguay", "Montevideo", "lala123",
                "7487", "099477811");
        checkOutPage.shippingAddressSet("Uruguay", "Montevideo", "Agraciasda",
                "3511", "094778188");
        checkOutPage.setShippingMethod("Next Day Air");
        checkOutPage.setPaymentMethAndInfo("Credit Card", "",
                "", "", "",
                "", "");
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        Assert.assertTrue(checkOutConfirmationPage.isOrderConfirmed());
        homePage = checkOutConfirmationPage.goLogOut();
    }

    @Test
    public void badLogin() {
        logInPage = homePage.goLoginPage();
        Assert.assertTrue(logInPage.mailField().isDisplayed());
        Assert.assertTrue(logInPage.passField().isDisplayed());
        Assert.assertTrue(logInPage.logBttn().isDisplayed());
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia12");
        Assert.assertTrue(logInPage.wrongLogIn());
        Assert.assertTrue(logInPage.passCleared());
        logInPage.clearMail();
        homePage = logInPage.loginUser("maildetest888@gmail.com", "lacontrasenia1234");
        //Crear un método que solo ingrese la password, porque el mail ya está
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        homePage.goLogOut();
    }


    @Test
    public void clearWishList() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest888@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToWishList("Nokia Lumia 1020");
        wishListPage = searchPage.goWishListPage();
        Assert.assertTrue(wishListPage.wishListPageTitle());
        Assert.assertTrue(wishListPage.isAtWishList("Nokia Lumia 1020"));
        wishListPage.deleteItem("Nokia Lumia 1020");
        wishListPage.updateWishList();
        Assert.assertTrue(wishListPage.isWishListEmpty());
        homePage.goLogOut();
    }

    @Test
    public void cleanCart() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement("Nokia Lumia 1020");
        //Assert page title
        Assert.assertTrue(searchPage.objetoEncontrado("Nokia Lumia 1020"));
        searchPage.addToCart("Nokia Lumia 1020");
        cartPage = searchPage.goCartPage();
        Assert.assertTrue(cartPage.cartPageTitle());
        cartPage.deleteItem("Nokia Lumia 1020");
        //No hace click
        cartPage.updateCart();
        Assert.assertTrue(cartPage.isCartEmpty());
        homePage.goLogOut();
    }

    @Test
    public void changeCurrency() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest14@gmail.com", "lacontrasenia1234");
        homePage.cambioMoneda("Dolar");
        Assert.assertTrue(homePage.verificarCambioMoneda("Dolar"));
        homePage.goLogOut();
    }

    @Test
    public void changeEmail() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest88@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        myAccountPage = homePage.goMyAccount();
        //My account page title assert
        myAccountPage.clearMail();
        myAccountPage.completeNewMail("maildetest888@gmail.com");
        myAccountPage.saveChanges();
        homePage = myAccountPage.goLogOut();
        //User loged out asssert
        homePage.goLoginPage();
        //Login page tittle assert
        homePage = logInPage.loginUser("maildetest888@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        homePage.goLogOut();
    }

}