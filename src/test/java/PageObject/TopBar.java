package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopBar {

    WebDriver driver;
    WebDriverWait wait;



    public TopBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
           }


    @FindBy(className = "ico-register")
    WebElement registerIcon;

    @FindBy(className = "ico-login")
    WebElement loginIcon;

    @FindBy(className = "ico-logout")
    WebElement logoutIcon;

    @FindBy(className = "cart-label")
    WebElement shoppingCartIcon;

    @FindBy(className = "wishlist-label")
    WebElement wishlistIcon;

    @FindBy(className = "ico-account")
    WebElement accountIcon;

    CurrencyChange currencyChange;

    public LogInPage goLoginPage () {
        SeleniumUtils.clickElement(loginIcon, wait);
        return new LogInPage(driver);
    }

    public RegisterPage goRegisterPage() {
        SeleniumUtils.clickElement(registerIcon, wait);
        return new RegisterPage(driver);
    }

    public HomePage userLogOut () {
        SeleniumUtils.clickElement(logoutIcon, wait);
        return new HomePage(driver);
    }

    public CartPage goCartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        driver.findElement(By.xpath("//span[@class='close']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='content']")));
        SeleniumUtils.clickElement(shoppingCartIcon, wait);
        return new CartPage(driver);
    }


    public WishListPage goWishListPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        driver.findElement(By.xpath("//span[@class='close']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='content']")));
        SeleniumUtils.clickElement(wishlistIcon, wait);
        return new WishListPage(driver);
    }

    public MyAccountPage goMyAccount () {
        SeleniumUtils.clickElement(accountIcon, wait);
        return new MyAccountPage(driver);
    }

    public void cambioMondera (String moneda) {
        currencyChange.currencyChose(moneda);
    }

}
