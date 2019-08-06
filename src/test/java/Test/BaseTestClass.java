package Test;

import PageObject.*;
import Utils.SeleniumUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import sun.awt.OSInfo;
import java.io.IOException;

public class BaseTestClass {

    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected static SoftAssert SA;
    protected BasePage basePage;
    protected HomePage homePage;
    protected NavigationBar navigationBar;
    protected TopBar topBar;
    protected RegisterPage registerPage;
    protected RegisterCompletePage registerCompletePage;
    protected LogInPage logInPage;
    protected SearchPage searchPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected CheckOutConfirmationPage checkOutConfirmationPage;
    protected WishListPage wishListPage;
    protected MyAccountPage myAccountPage;
    protected ComparationPage comparationPage;

    //Configuración para cada Método o Caso de Prueba
    @BeforeMethod(alwaysRun = true)
    public void startSetup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }


    }

