package com.epam.mentoring.yandex.disk.listener;

import com.epam.mentoring.core.SendScreenshot;
import com.epam.mentoring.driver.DriverSingleton;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import rp.com.google.common.base.Throwables;

public class TestListener extends ReportPortalTestNGListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart (ITestResult iTestResult) {
        logger.info("Start test : " + iTestResult.getName());
        super.onTestStart(iTestResult);
    }

    @Override
    public void onTestSuccess (ITestResult iTestResult) {
        logger.info("Test Success " + iTestResult.getName());
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure (ITestResult iTestResult) {
        String errorMsg = String.format("Test failed.%nURL: %s%nException: %s%nStack trace:%n%s",
                                        DriverSingleton.getDriver().getCurrentUrl(), iTestResult.getThrowable().getMessage(),
                                        Throwables.getStackTraceAsString(iTestResult.getThrowable()));
        SendScreenshot.with(errorMsg, Level.ERROR);
        logger.info("Test Fail " + iTestResult.getName());
        super.onTestFailure(iTestResult);
    }

    @Override
    public void onTestSkipped (ITestResult iTestResult) {
        logger.info("Test Skipped " + iTestResult.getName());
        super.onTestSkipped(iTestResult);
    }

}
