package com.epam.mentoring.yandex.disk.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
}
