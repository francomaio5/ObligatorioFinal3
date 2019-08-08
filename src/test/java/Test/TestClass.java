package Test;

import Utils.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class TestClass extends BaseTestClass {

    @Test(dataProvider = "CP1UserRegister",dataProviderClass = DataProviderClass.class)
    public void CP1testRegistroUsuario(String nombre, String apellido, String mail,
                                       String pass, Method method) {
        extentTest = extentReports.createTest(method.getName());
        registerPage = homePage.goRegisterPage();
        Assert.assertTrue(registerPage.emailFieldIsDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.passFieldDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.confPasswordDisplayed().isDisplayed());
        Assert.assertTrue(registerPage.contBttnDisplayed().isDisplayed());
        registerCompletePage = registerPage.registerNewUser(nombre, apellido, mail, pass);
        Assert.assertTrue(registerCompletePage.registerConfirm());
        Assert.assertTrue(registerCompletePage.logOutIconDisplayed().isDisplayed());
        homePage = registerCompletePage.goLogOut();
    }

    @Test(dataProvider = "CP2CheckOutEfectivo",dataProviderClass = DataProviderClass.class)
    public void CP2testCheckOutEfectivo(String mail, String pass, String elemento, String billCountry,
                                        String billCity, String billAddress, String billZipCode,
                                        String billPhoneNumb, String shippCountry, String shippCity,
                                        String shippAddress, String shippZipCode, String shippPhNumb,
                                        String shippMethod, String paymentType, String ccType,
                                        String ccHolderName, String ccNumber, String ccExpMonth,
                                        String  ccExpYear, String ccCode, Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(mail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement(elemento);
        Assert.assertTrue(searchPage.objetoEncontrado(elemento));
        searchPage.addToCart(elemento);
        cartPage = searchPage.goCartPage();
        Assert.assertTrue(cartPage.cartPageTitle());
        checkOutPage = cartPage.goCheckOutPage();
        Assert.assertTrue(checkOutPage.checkOutPageTitle());
        checkOutPage.billingAddressSet(billCountry, billCity, billAddress, billZipCode, billPhoneNumb);
        checkOutPage.shippingAddressSet(shippCountry, shippCity, shippAddress, shippZipCode, shippPhNumb);
        checkOutPage.setShippingMethod(shippMethod);
        checkOutPage.setPaymentMethAndInfo(paymentType, ccType, ccHolderName, ccNumber, ccExpMonth,
                ccExpYear, ccCode);
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        Assert.assertTrue(checkOutConfirmationPage.isOrderConfirmed());
        homePage = checkOutConfirmationPage.goLogOut();
    }

    @Test(dataProvider = "CP3CheckOutEfectivo",dataProviderClass = DataProviderClass.class)
    public void CP3testCheckOutCreditCard(String mail, String pass, String elemento, String billCountry,
                                          String billCity, String billAddress, String billZipCode,
                                          String billPhoneNumb, String shippCountry, String shippCity,
                                          String shippAddress, String shippZipCode, String shippPhNumb,
                                          String shippMethod, String paymentType, String ccType,
                                          String ccHolderName, String ccNumber, String ccExpMonth,
                                          String  ccExpYear, String ccCode, Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(mail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement(elemento);
        Assert.assertTrue(searchPage.objetoEncontrado(elemento));
        searchPage.addToCart(elemento);
        cartPage = searchPage.goCartPage();
        Assert.assertTrue(cartPage.cartPageTitle());
        checkOutPage = cartPage.goCheckOutPage();
        Assert.assertTrue(checkOutPage.checkOutPageTitle());
        checkOutPage.billingAddressSet(billCountry, billCity, billAddress, billZipCode, billPhoneNumb);
        checkOutPage.shippingAddressSet(shippCountry, shippCity, shippAddress, shippZipCode, shippPhNumb);
        checkOutPage.setShippingMethod(shippMethod);
        checkOutPage.setPaymentMethAndInfo(paymentType, ccType, ccHolderName, ccNumber, ccExpMonth,
                ccExpYear, ccCode);
        checkOutConfirmationPage = checkOutPage.confirmOrder();
        Assert.assertTrue(checkOutConfirmationPage.isOrderConfirmed());
        homePage = checkOutConfirmationPage.goLogOut();
    }

    @Test(dataProvider = "CP4AddWishList",dataProviderClass = DataProviderClass.class)
    public void CP4testAgregarWishList(String mail, String pass, String elemento, Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(mail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement(elemento);
        Assert.assertTrue(searchPage.searchPageTitle());
        Assert.assertTrue(searchPage.objetoEncontrado(elemento));
        searchPage.addToWishList(elemento);
        wishListPage = searchPage.goWishListPage();
        Assert.assertTrue(wishListPage.wishListPageTitle());
        Assert.assertTrue(wishListPage.isAtWishList(elemento));
        homePage = wishListPage.goLogOut();
    }

    @Test(dataProvider = "CP5CompararProductos",dataProviderClass = DataProviderClass.class)
    public void CP5testCompararProductos(String mail, String pass, String keyWord, String elemento1,
                                         String elemento2, Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(mail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement(keyWord);
        Assert.assertTrue(searchPage.objetoEncontrado(elemento1));
        Assert.assertTrue(searchPage.objetoEncontrado(elemento2));
        searchPage.addToCompareList(elemento1);
        searchPage.addToCompareList(elemento2);
        comparationPage = searchPage.goComparePage();
        Assert.assertTrue(comparationPage.comparePageTitle());
        Assert.assertTrue(comparationPage.itsOnComparePage(elemento1));
        Assert.assertTrue(comparationPage.itsOnComparePage(elemento2));
        homePage = comparationPage.goLogOut();
    }

    @Test(dataProvider = "CP6logInIncorrecto",dataProviderClass = DataProviderClass.class)
    public void CP6logInIncorrecto(String mail, String wrongPass, String pass, Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        Assert.assertTrue(logInPage.mailField().isDisplayed());
        Assert.assertTrue(logInPage.passField().isDisplayed());
        Assert.assertTrue(logInPage.logBttn().isDisplayed());
        homePage = logInPage.loginUser(mail, wrongPass);
        Assert.assertTrue(logInPage.wrongLogIn());
        Assert.assertTrue(logInPage.passCleared());
        logInPage.clearMail();
        homePage = logInPage.loginUser(mail, pass);
        //Crear un método que solo ingrese la password, porque el mail ya está
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        homePage.goLogOut();
    }


    @Test(dataProvider = "CP7testClearWishList",dataProviderClass = DataProviderClass.class)
    public void CP7testClearWishList(String mail, String pass, String element, Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(mail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement(element);
        Assert.assertTrue(searchPage.objetoEncontrado(element));
        searchPage.addToWishList(element);
        wishListPage = searchPage.goWishListPage();
        Assert.assertTrue(wishListPage.wishListPageTitle());
        Assert.assertTrue(wishListPage.isAtWishList(element));
        wishListPage.deleteItem(element);
        wishListPage.updateWishList();
        Assert.assertTrue(wishListPage.isWishListEmpty());
        homePage = wishListPage.goLogOut();
    }

    @Test(dataProvider = "CP8testClearCart",dataProviderClass = DataProviderClass.class)
    public void CP8testClearCart(String mail, String pass, String element, Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(mail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        searchPage = homePage.searchElement(element);
        Assert.assertTrue(searchPage.searchPageTitle());
        Assert.assertTrue(searchPage.objetoEncontrado(element));
        searchPage.addToCart(element);
        cartPage = searchPage.goCartPage();
        Assert.assertTrue(cartPage.cartPageTitle());
        cartPage.deleteItem(element);
        cartPage.updateCart();
        Assert.assertTrue(cartPage.isCartEmpty());
        homePage = cartPage.goLogOut();
    }

    @Test(dataProvider = "CP9testChangeCurrency",dataProviderClass = DataProviderClass.class)
    public void CP9testChangeCurrency(String fstCurrency, String mail, String pass, String scnCurrency,
                                      Method method) {
        extentTest = extentReports.createTest(method.getName());

        homePage.cambioMoneda(fstCurrency);
        Assert.assertTrue(homePage.verificarCambioMoneda(fstCurrency));
        logInPage = homePage.goLoginPage();
        Assert.assertTrue(logInPage.logInPageTittle());
        homePage = logInPage.loginUser(mail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        homePage.cambioMoneda(scnCurrency);
        Assert.assertTrue(homePage.verificarCambioMoneda(scnCurrency));
        homePage.goLogOut();
    }

    @Test(dataProvider = "CP10testChangeMail",dataProviderClass = DataProviderClass.class)
    public void CP10testChangeMail(String oldMail, String pass, String newMail, String newPass,
                                   Method method) {
        extentTest = extentReports.createTest(method.getName());

        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(oldMail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        myAccountPage = homePage.goMyAccount();
        Assert.assertTrue(myAccountPage.myAccountTittle());
        myAccountPage.clearMail();
        myAccountPage.completeNewMail(newMail);
        myAccountPage.saveChanges();
        homePage = myAccountPage.goLogOut();
        Assert.assertTrue(homePage.userIsLogedOut().isDisplayed());
        homePage.goLoginPage();
        Assert.assertTrue(logInPage.logInPageTittle());
        homePage = logInPage.loginUser(newMail, pass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        myAccountPage = homePage.goMyAccount();
        changePasswordPage = myAccountPage.goChangePasswordPage();
        changePasswordPage.changePasswordOk(pass, newPass);
        homePage = changePasswordPage.goLogOut();
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser(newMail, newPass);
        Assert.assertTrue(homePage.logOutIconDisplayed().isDisplayed());
        homePage.goLogOut();
        Assert.assertTrue(homePage.userIsLogedOut().isDisplayed());
    }

}