package PageObject;

//import Test.NavigationBar;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TopBar topBar;
    protected NavigationBar navigationBar;
    protected FooterBar footerBar;
    protected static String productName;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        topBar = new TopBar(driver);
        navigationBar = new NavigationBar(driver);
    }

    public RegisterPage goRegisterPage () {
        return topBar.goRegisterPage();
    }

    public LogInPage goLoginPage() {
        return topBar.goLoginPage();
    }

    public SearchPage searchElement(String objeto) {
        return navigationBar.buscarObjeto(objeto);
    }

    public CartPage goCartPage() {
        return topBar.goCartPage();
    }

    public WishListPage goWishListPage() { return topBar.goWishListPage(); }

    public HomePage goLogOut() { return topBar.userLogOut(); }

    public MyAccountPage goMyAccount () { return topBar.goMyAccount(); }

    public ComparationPage goComparePage() {return footerBar.goComparationPage(); }

    public List<WebElement> findElements(By locator){ return SeleniumUtils.findElements(driver, locator); }

//    public void changeCurrency(String moneda){ topBar.selectCurrency(moneda); }

}
