package com.epam.mentoring.core;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.util.DateUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.apache.logging.log4j.Level.INFO;

public interface SendScreenshot {

    static void with (String message, Level level) {
        Logger logger = LogManager.getRootLogger();

        File screenshot = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(".//target/screenshots/" + DateUtils.getCurrentTimeAsString() + ".jpg"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
        String msg = String.format("RP_MESSAGE#FILE#%s#%s", screenshot.getAbsolutePath(), message);
        logger.info("Screenshot: {" + screenshot.getAbsolutePath() + "}");
        logger.log(level, msg);
    }

    static void with (String message) {
        with(message, INFO);
    }

}
