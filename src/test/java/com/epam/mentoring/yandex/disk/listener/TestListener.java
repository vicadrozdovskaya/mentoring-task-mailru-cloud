package com.epam.mentoring.yandex.disk.listener;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.util.DateUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    private static final Logger logger = Logger.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) {
        logger.info("Start test : " + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test Success " + iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test Fail " + iTestResult.getName());
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test Skipped " + iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                    + DateUtils.getCurrentTimeAsString() +
                    ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }


}
