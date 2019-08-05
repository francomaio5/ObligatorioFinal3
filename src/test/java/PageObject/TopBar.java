package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        SeleniumUtils.clickElement(shoppingCartIcon, wait);
        return new CartPage(driver);
    }


    public WishListPage goWishListPage() {
        SeleniumUtils.clickElement(wishlistIcon, wait);
        return new WishListPage(driver);
    }
}
