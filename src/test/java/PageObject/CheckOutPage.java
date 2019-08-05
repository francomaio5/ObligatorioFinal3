package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

    //Elementos del Check Out Page
    //1-Billing address

    @FindBy(id = "ShipToSameAddress")
    WebElement shipSameAddress;

    @FindBy(id = "BillingNewAddress_Company")
    WebElement billingNewCompany;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement billingCountrySelect;

    @FindBy(id = "BillingNewAddress_City")
    WebElement billingNewCity;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement billingNewAddress1;

    @FindBy(id = "BillingNewAddress_Address2")
    WebElement billingNewAddress2;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement billingNewZipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement billingNewPhNumber;

    @FindBy(id = "BillingNewAddress_FaxNumber")
    WebElement billingNewFaxNumber;

    @FindBy(id = "billing-address-select")
    WebElement billingAdressDrop;

    @FindBy(className = "new-address-next-step-button")
    WebElement billingContinueBttn;

    //2-Shipping Address

    @FindBy(css = "#shipping-buttons-container .new-address-next-step-button")
    WebElement shippingAddresContBttn;

    //3-Shipping Method

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


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutConfirmationPage doCheckOut (String company, String country, String city,
                                                String address1, String address2, String zipCode,
                                                String phNumber, String faxNumber, String shippingMethod,
                                                String paymentMethod, String ccType,
                                                String ccHolderName, String ccNumber,
                                                String ccExpMonth, String ccExpYear, String ccCode) {
        //1-Billing address
        boolean isAddresSet = billingAdressDrop.isDisplayed();

        //If que verifica si es o no el primer envío
        if (isAddresSet) {
            SeleniumUtils.clickElement(shipSameAddress, wait);
            Select comboAddress = new Select(billingAdressDrop);
            comboAddress.selectByVisibleText("New Address");

        } else {
            SeleniumUtils.clickElement(shipSameAddress, wait);
        }

        SeleniumUtils.sendText(billingNewCompany, wait, company);
        Select comboCountry = new Select(billingCountrySelect);
        comboCountry.selectByVisibleText(country);
        SeleniumUtils.sendText(billingNewCity, wait, city);
        SeleniumUtils.sendText(billingNewAddress1, wait, address1);
        SeleniumUtils.sendText(billingNewAddress2, wait, address2);
        SeleniumUtils.sendText(billingNewZipCode, wait, zipCode);
        SeleniumUtils.sendText(billingNewPhNumber, wait, phNumber);
        SeleniumUtils.sendText(billingNewFaxNumber, wait, faxNumber);
        SeleniumUtils.clickElement(shipSameAddress, wait);
        SeleniumUtils.clickElement(billingContinueBttn, wait);

        //2-Shipping Address
        if (isAddresSet == false){
            SeleniumUtils.clickElement(shippingAddresContBttn, wait);}
        //3-Shipping Method
        if (shippingMethod.equals("Ground")) {
            SeleniumUtils.clickElement(groundShipping, wait);
        }
        else if (shippingMethod.equals("Next Day Air")) {
            SeleniumUtils.clickElement(nextDayAirShipping, wait);
        } else if (shippingMethod.equals("2nd Day Air")){
            SeleniumUtils.clickElement(scndDayAirShipping, wait);
        }
        SeleniumUtils.clickElement(shippingMethContinue, wait);
        //4-Payment Method
        if (paymentMethod.equals("Credit Card")) {
            SeleniumUtils.clickElement(creditCardOption, wait);
        } else {
            SeleniumUtils.clickElement(moneyOrderOption, wait);
        }
        SeleniumUtils.clickElement(paymentMethContinue, wait);
        //5- Payment information
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
        //6- Confirm order
        SeleniumUtils.clickElement(confirmOrderContinue, wait);


        return new CheckOutConfirmationPage(driver);
    }

    }
