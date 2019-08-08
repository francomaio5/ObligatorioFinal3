package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "CP1UserRegister")
    public static Object[][] getDataFromDataProviderCompleteRegister(){
        return new Object[][]
                {
                        {"Juan","Perez","maildetest56@gmail.com","pass00"}
                };
    }

    @DataProvider(name = "CP2CheckOutEfectivo")
    public static Object[][] getDataFromDataProviderCheckOutEfectivo(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass00","Nokia Lumia 1020","Uruguay", "Montevideo",
                        "Avenida Italia 4744", "47444", "094778188", "Uruguay", "Montevideo",
                        "Zapican 2590", "11800", "094778188", "2nd Day Air", "Non Credit Card", "",
                        "", "", "", "", ""}
                };
    }

    @DataProvider(name = "CP3CheckOutEfectivo")
    public static Object[][] getDataFromDataProviderCheckOutCreditCard(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass00","Nokia Lumia 1020","Uruguay", "Montevideo",
                                "Avenida Italia 4744", "47444", "094778188", "Uruguay", "Montevideo",
                                "Zapican 2590", "11800", "094778188", "Ground", "Credit Card", "Master card",
                                "Juan Raul Perez", "5555555555554444", "08", "2021", "783"}
                };
    }

    @DataProvider(name = "CP4AddWishList")
    public static Object[][] getDataFromDataProviderAddWishList(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass00","Nokia Lumia 1020"},
                        {"maildetest56@gmail.com", "pass00","HTC One M8 Android L 5.0 Lollipop"},
                        {"maildetest56@gmail.com", "pass00","Asus N551JK-XO076H Laptop"},
                        {"maildetest56@gmail.com", "pass00","Fahrenheit 451 by Ray Bradbury"},
                        {"maildetest56@gmail.com", "pass00","Flower Girl Bracelet"}
                };
    }

    @DataProvider(name = "CP5CompararProductos")
    public static Object[][] getDataFromDataProviderCompareProducts(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass00","Ultrabook", "HP Spectre XT Pro UltraBook",
                                "Samsung Series 9 NP900X4C Premium Ultrabook"}
                };
    }

    @DataProvider(name = "CP6logInIncorrecto")
    public static Object[][] getDataFromDataProviderBadLogIn(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass09","pass00"}
                };
    }

    @DataProvider(name = "CP7testClearWishList")
    public static Object[][] getDataFromDataProviderClearWishList(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass00","Nokia Lumia 1020"}
                };
    }

    @DataProvider(name = "CP8testClearCart")
    public static Object[][] getDataFromDataProviderClearCart(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass00","Nokia Lumia 1020"}
                };
    }

    @DataProvider(name = "CP9testChangeCurrency")
    public static Object[][] getDataFromDataProviderChangeCurrency(){
        return new Object[][]
                {
                        {"Euro","maildetest56@gmail.com","pass00","Dolar"}
                };
    }

    @DataProvider(name = "CP10testChangeMail")
    public static Object[][] getDataFromDataProviderChangeEmail(){
        return new Object[][]
                {
                        {"maildetest56@gmail.com","pass00","maildetest57@gmail.com", "pass001"}
                };
    }
}


/*

 */