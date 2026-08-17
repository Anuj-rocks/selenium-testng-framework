import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class listener implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("target/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());

        test.info("Test Started");
    }

    private void captureScreenshot(ITestResult result, String status) {
        TakesScreenshot ts = null;

        try {
            java.lang.reflect.Field driverField = Selenium.class.getDeclaredField("driver");
            driverField.setAccessible(true);
            Object driver = driverField.get(null);
            if (driver instanceof TakesScreenshot) {
                ts = (TakesScreenshot) driver;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ts == null) {
            return;
        }

        File folder = new File("target/screenshots");
        folder.mkdirs();

        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(folder, result.getName() + "_" + status + ".png");

        try {
            FileUtils.copyFile(source, destination);
            test.addScreenCaptureFromPath(destination.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
        captureScreenshot(result, "pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");
        captureScreenshot(result, "fail");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}