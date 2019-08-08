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
    protected ChangePasswordPage changePasswordPage;

    //reportes
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        setupReports();
    }

    public void setupReports() {
        extentHtmlReporter = new ExtentHtmlReporter("reports/reporte.html");
        extentHtmlReporter.config().setDocumentTitle("Automation Reports");
        extentHtmlReporter.config().setReportName("Obligatorio Franco Maio - " +
                "Reporte de Test Automatizados en el sitio demo.nopcommerce.com");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Ambiente", "Testing");
        extentReports.setSystemInfo("Hostname", "nopcommerce");
        extentReports.setSystemInfo("Sistema Operativo", OSInfo.getOSType().name());
        extentReports.setSystemInfo("Obligatorio", "Franco Maio");
    }

    //Configuración para cada Método o Caso de Prueba
    @BeforeMethod(alwaysRun = true)
    public void startSetup() {
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardownTest(ITestResult resultadoDeTest) throws IOException {

        if (resultadoDeTest.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test Case " + resultadoDeTest.getName() + " failed");
            extentTest.log(Status.FAIL, "Caused: " + resultadoDeTest.getThrowable());
        } else if (resultadoDeTest.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case " + resultadoDeTest.getName() + " skipped");
            extentTest.log(Status.SKIP, "Caused: " + resultadoDeTest.getThrowable());
        } else if (resultadoDeTest.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test Case " + resultadoDeTest.getName() + " passed");
        }
    }


    @AfterSuite(alwaysRun = true)
    public void flush() {
        extentReports.flush();
        driver.quit();
    }
}


