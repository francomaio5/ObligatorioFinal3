package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends  BasePage{

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement pageTitle;

    //1- Billing address
    @FindBy(id = "ShipToSameAddress")
    WebElement shipToSameAddres;

    @FindBy(id = "billing-address-select")
    WebElement billingAddressCombo;

    @FindBy(name = "BillingNewAddress.CountryId")
    WebElement billingCountry;

    @FindBy(id = "BillingNewAddress_City")
    WebElement billingCity;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement billingAddres1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement billingZipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement billingPhNumber;

    @FindBy(className = "new-address-next-step-button")
    WebElement billingContinueBttn;

    //2-Shipping address

    @FindBy(css = "#shipping-address-select")
    WebElement shippingAddressCombo;

    @FindBy(name = "ShippingNewAddress.CountryId")
    WebElement shippingCountryCombo;

    @FindBy(name = "ShippingNewAddress.City")
    WebElement shippingCity;

    @FindBy(name = "ShippingNewAddress.Address1")
    WebElement shippingAddress1;

    @FindBy(name = "ShippingNewAddress.ZipPostalCode")
    WebElement shippingZipCode;

    @FindBy(name = "ShippingNewAddress.PhoneNumber")
    WebElement shippingPhoneNumber;

    @FindBy(css = "#shipping-buttons-container .new-address-next-step-button")
    WebElement shippingContinueBttn;

    //3-Shipping method

    @FindBy(id = "shippingoption_0")
    WebElement groundShipping;

    @FindBy(id = "shippingoption_1")
    WebElement nextDayAirShipping;

    @FindBy(id = "shippingoption_2")
    WebElement scndDayAirShipping;

    @FindBy(className = "shipping-method-next-step-button")
    WebElement shippingMethContinue;

    //4-Payment Method

    @FindBy(id = "paymentmethod_0")
    WebElement moneyOrderOption;

    @FindBy(id = "paymentmethod_1")
    WebElement creditCardOption;

    @FindBy(className = "payment-method-next-step-button")
    WebElement paymentMethContinue;

    //5-Payment Information

    @FindBy(id = "CreditCardType")
    WebElement creditCardType;

    @FindBy(id = "CardholderName")
    WebElement cardHolderName;

    @FindBy(id = "CardNumber")
    WebElement cardNumber;

    @FindBy(id = "ExpireMonth")
    WebElement expMonth;

    @FindBy(id = "ExpireYear")
    WebElement expYear;

    @FindBy(id = "CardCode")
    WebElement cardCode;

    @FindBy(className = "payment-info-next-step-button")
    WebElement paymentInfoContinue;

    //6-Confirm Order

    @FindBy(className = "confirm-order-next-step-button")
    WebElement confirmOrderContinue;



    public void billingAddressSet (String billCountry, String billCity, String billAddres1, String  billZipCode,
                                   String billPhNumb) {

        boolean billingAddressIsSet = billingAddressCombo.isDisplayed();

        if (billingAddressIsSet) {
            Select addressBillSelect = new Select (billingAddressCombo);
            addressBillSelect.selectByVisibleText("New Address");
        } else {

        }

        SeleniumUtils.clickElement(shipToSameAddres, wait);
        Select billingCountrySelect = new Select(billingCountry);
        billingCountrySelect.selectByVisibleText(billCountry);
        SeleniumUtils.sendText(billingCity, wait, billCity);
        SeleniumUtils.sendText(billingAddres1, wait, billAddres1);
        SeleniumUtils.sendText(billingZipCode, wait, billZipCode);
        SeleniumUtils.sendText(billingPhNumber, wait, billPhNumb);
        SeleniumUtils.clickElement(billingContinueBttn, wait);
    }

    public void shippingAddressSet (String shippCountry ,String shippCity, String shippAddres1, String  shippZipCode,
                                    String shippPhNumb) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("shipping-address-select")));
        Select addressShippingSelect = new Select(shippingAddressCombo);
        addressShippingSelect.selectByVisibleText("New Address");
        Select countryShipp = new Select(shippingCountryCombo);
        countryShipp.selectByVisibleText(shippCountry);
        SeleniumUtils.sendText(shippingCity, wait, shippCity );
        SeleniumUtils.sendText(shippingAddress1, wait, shippAddres1);
        SeleniumUtils.sendText(shippingZipCode, wait, shippZipCode);
        SeleniumUtils.sendText(shippingPhoneNumber, wait, shippPhNumb);
        SeleniumUtils.clickElement(shippingContinueBttn, wait);

    }

    public void setShippingMethod (String shippingType) {
        if (shippingType.equals("Ground")) {
            SeleniumUtils.clickElement(groundShipping, wait);
        }
        else if (shippingType.equals("Next Day Air")) {
            SeleniumUtils.clickElement(nextDayAirShipping, wait);
        } else if (shippingType.equals("2nd Day Air")){
            SeleniumUtils.clickElement(scndDayAirShipping, wait);
        }
        SeleniumUtils.clickElement(shippingMethContinue, wait);

    }

    public void setPaymentMethAndInfo (String paymentMethod, String ccType, String ccHolderName, String ccNumber,
                                       String ccExpMonth,String ccExpYear, String ccCode) {
        if (paymentMethod.equals("Credit Card")) {
            SeleniumUtils.clickElement(creditCardOption, wait);
        } else {
            SeleniumUtils.clickElement(moneyOrderOption, wait);
        }
        SeleniumUtils.clickElement(paymentMethContinue, wait);
        //Payment information
        if(paymentMethod.equals("Credit Card")) {
            SeleniumUtils.clickElement(creditCardType, wait);
            Select comboCreditCard = new Select(creditCardType);
            comboCreditCard.selectByVisibleText(ccType);
            SeleniumUtils.sendText(cardHolderName, wait, ccHolderName);
            SeleniumUtils.sendText(cardNumber, wait, ccNumber);
            SeleniumUtils.clickElement(expMonth, wait);
            Select comboExpMonth = new Select(expMonth);
            comboExpMonth.selectByVisibleText(ccExpMonth);
            SeleniumUtils.clickElement(expYear, wait);
            Select comboExpYear = new Select (expYear);
            comboExpYear.selectByVisibleText(ccExpYear);
            SeleniumUtils.sendText(cardCode, wait, ccCode);
            SeleniumUtils.clickElement(paymentInfoContinue, wait);
        } else {
            SeleniumUtils.clickElement(paymentInfoContinue, wait); }
    }

    public CheckOutConfirmationPage confirmOrder () {
        SeleniumUtils.clickElement(confirmOrderContinue, wait);
        return new CheckOutConfirmationPage(driver);
    }

    public boolean checkOutPageTitle () {
        return pageTitle.getText().contains("Checkout");
    }



}