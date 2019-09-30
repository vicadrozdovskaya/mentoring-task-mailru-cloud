package com.epam.mentoring.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static final ResourceBundle rb;
    private static WebDriver driver;

    static {
        rb = ResourceBundle.getBundle("driver");
    }

    private DriverSingleton () { }

    public static WebDriver getDriver () {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                break;
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(rb.getString("driver.page.load.timeout")), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(rb.getString("driver.implicitly.wait")), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver () {
        driver.quit();
        driver = null;
    }
}
