package com.epam.mentoring.mailru.cloud.pages;

import com.epam.mentoring.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPage {
    private final static int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    public AbstractPage () {
        this.driver = DriverSingleton.getDriver();
       // if (getClass().isAnnotationPresent(PageFactory.class)) initElements(this.driver, this);
    }

    protected void waitForElementsVisible (By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
