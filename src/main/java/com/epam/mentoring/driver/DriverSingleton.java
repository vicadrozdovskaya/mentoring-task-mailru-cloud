package com.epam.mentoring.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static final ResourceBundle rb;
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(()->null);

    static {
        rb = ResourceBundle.getBundle("driver");
    }

    private DriverSingleton () { }

    public static WebDriver getDriver () {
        if (null == driver.get()) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                }
                break;
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                }
            }
            driver.get().manage().timeouts().pageLoadTimeout(Integer.parseInt(rb.getString("driver.page.load.timeout")), TimeUnit.SECONDS);
            driver.get().manage().timeouts().implicitlyWait(Integer.parseInt(rb.getString("driver.implicitly.wait")), TimeUnit.SECONDS);
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void closeDriver () {
            driver.get().quit();
            driver.remove();
    }
}
