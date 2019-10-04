package com.epam.mentoring.yandex.disk.services.stepdefs;

import com.epam.mentoring.driver.DriverSingleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ScenarioHooks {
    @Before
    public void beforeScenario () {
    }

    @After
    public void afterScenario () {
        DriverSingleton.closeDriver();
    }
}
