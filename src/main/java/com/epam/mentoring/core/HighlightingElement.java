package com.epam.mentoring.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.epam.mentoring.driver.DriverSingleton.getDriver;

public interface HighlightingElement {

    static void highlightElement (WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='5px solid green'", element);
    }

    static void unHighlightElement (WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='0px'", element);
    }
}
