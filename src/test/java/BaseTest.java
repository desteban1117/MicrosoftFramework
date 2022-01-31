import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import drivers.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    static ExtentTest test;
    static ExtentReports report;

    @BeforeSuite
    public void beforeSuit() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        report = new ExtentReports(System.getProperty("user.dir")+"\\target\\reports\\Report" +
                dtf.format(LocalDateTime.now()) + ".html");
        test = report.startTest("Microsoft Tests");
    }

    @BeforeTest
    public void beforeTest() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10, 0));
        Driver.getDriver().get("https://www.microsoft.com/es-mx/");
    }

    @AfterMethod
    public void afterMethod(ITestResult result, ITestContext context) throws IOException {
        if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, context.getName());
        }

        if(result.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            File Dest = new File(System.getProperty("user.dir") + "\\target\\reports\\img" + System.currentTimeMillis()
                    + ".png");
            String errflpath = Dest.getAbsolutePath();
            FileUtils.copyFile(scrFile, Dest);
            test.log(LogStatus.FAIL,test.addScreenCapture(errflpath)+ context.getName() + "\nError: " + result.getThrowable().getMessage());
        }
    }
    @AfterTest
    public void afterTest() {
        Driver.quitDriver();
    }

    @AfterSuite
    public void afterSuit() {
        report.endTest(test);
        report.flush();
    }
}
