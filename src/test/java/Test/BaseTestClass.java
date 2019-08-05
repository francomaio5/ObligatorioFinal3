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


//    protected static ExtentHtmlReporter extentHtmlReporter;
//    protected static ExtentReports extentReports;
//    protected static ExtentTest extentTest;
//
//    //Set Up de los Reportes
//    public void setupReports() {
//        extentHtmlReporter = new ExtentHtmlReporter("reports/reporte.html");
//        extentHtmlReporter.config().setDocumentTitle("Reporte de automatización");
//        extentHtmlReporter.config().setReportName("nopcommerce Demo Site- Reporte de Pruebas Automatizadas");
//        extentHtmlReporter.config().setTheme(Theme.DARK);
//
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(extentHtmlReporter);
//
//        extentReports.setSystemInfo("Ambiente", "Testing");
//        extentReports.setSystemInfo("Hostname", "opencart.testing.us");
//        extentReports.setSystemInfo("Sistema Operativo", OSInfo.getOSType().name());
//    }
//
//    //Configuración de la Suite de Pruebas
//    @BeforeSuite(alwaysRun = true)
//    public void setupSuite() {
//        setupReports();
//    }

    //Configuración para cada Método o Caso de Prueba
    @BeforeMethod(alwaysRun = true)
    public void startSetup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

//    //Finalización de cada Método o Caso de Prueba
//    @AfterMethod(alwaysRun = true)
//    public void testConclution(final ITestResult result) throws IOException {
//        SA.assertAll();
//        if (result.getStatus() == ITestResult.FAILURE) {
//            extentTest.log(Status.FAIL, "Test Case " + result.getName() + " failed");
//            extentTest.log(Status.FAIL, "Caused: " + result.getThrowable());
//            String screenShoot = SeleniumUtils.takeScreenShot(driver);
//            extentTest.log(Status.FAIL, "Image: ");
//            extentTest.addScreenCaptureFromPath(screenShoot);
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            extentTest.log(Status.SKIP, "Test Case " + result.getName() + " skipped");
//            extentTest.log(Status.SKIP, "Caused: " + result.getThrowable());
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            extentTest.log(Status.PASS, "Test Case " + result.getName() + " passed");
//        }
//    }
//
//    //Finalización de la Suite de Pruebas
//    @AfterSuite(alwaysRun = true)
//    public void flush() {
//        extentReports.flush();
//        driver.quit();
//    }


    }

