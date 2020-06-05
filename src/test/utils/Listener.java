package test.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class Listener implements
        ISuiteListener,
        ITestListener,
        IInvokedMethodListener {
    public Logger logger = LogManager.getLogger(Listener.class);

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        logger.trace("BEFORE INVOCATION");
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        logger.trace("AFTER INVOCATION");
    }

    @Override
    public void onStart(ISuite iSuite) {

    }

    @Override
    public void onFinish(ISuite iSuite) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.trace("TEST WAS SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Screenshot screenshot = new Screenshot((WebDriver) iTestResult.getTestContext().getAttribute("driver"));
        screenshot.getScreenshot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}