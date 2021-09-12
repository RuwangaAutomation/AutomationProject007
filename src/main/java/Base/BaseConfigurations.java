package main.java.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/*
Base configuration of the Automation framework that initialize the framework
and Configure basic core configurations.
 */
public class BaseConfigurations {

    public static WebDriver driver;
    public ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTest(){
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"JupiterCloudResultReprot.html");
        extentHtmlReporter.config().setEncoding("utf-8");
        extentHtmlReporter.config().setDocumentTitle("JupiterCloud Automation Result Reprot");
        extentHtmlReporter.config().setReportName("Automation Test Results");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Automation Tester","Planit");

    }

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethod(String browserName, Method testMethod){
        logger = extentReports.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus()== ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "PASSED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }else if (result.getStatus()== ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "FAILED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }else if (result.getStatus()== ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "SKIPED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
            logger.log(Status.SKIP,m);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }

    //initialize the web driver base on the given browser
    public void setupDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")){
            //TODO implementation to the FireFIx driver
        }else {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver");
            driver = new ChromeDriver();
        }
    }
}
