package com.epam.mentoring.yandex.disk.services.stepdefs;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;


@CucumberOptions (strict = true, features = "src/test/resources/features",    // if runner does not see the features
                  plugin = { "pretty", "json:target/Cucumber.json", "html:target/cucumber-html-report" })
public class CucumberTestNGTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void addProperty () {
        System.setProperty("browser", "chrome");
        System.setProperty("environment", "dev");
    }

}
