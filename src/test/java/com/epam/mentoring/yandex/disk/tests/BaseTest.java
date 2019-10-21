package com.epam.mentoring.yandex.disk.tests;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.model.creator.UserCreator;
import com.epam.mentoring.yandex.disk.services.pages.LoginStartService;
import com.epam.mentoring.yandex.disk.services.pages.YandexLoginService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass (groups = "yandexWithLogin")
    public void signIn () {
        new LoginStartService().openPage().clickEnterYandexDisk();
        new YandexLoginService().loginUser(UserCreator.withCredentialsFromProperty());
    }

    @BeforeClass (alwaysRun = true, description = "Start browser")
    private void initBrowser () {
        DriverSingleton.getDriver();
    }

    @AfterClass (alwaysRun = true, description = "close browser")
    public void kill () {
        DriverSingleton.closeDriver();
    }
}
