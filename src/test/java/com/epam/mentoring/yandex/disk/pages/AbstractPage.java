package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.decorator.CustomFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractPage {
    private final static int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    public AbstractPage () {
        this.driver = DriverSingleton.getDriver();
        initElements(new CustomFieldDecorator(driver), this);
        //if (getClass().isAnnotationPresent(PageFactory.class)) initElements(this.driver, this);
    }

    protected void waitForElementsVisible (By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitPageLoad(String url){
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.urlContains(url));
    }
}
