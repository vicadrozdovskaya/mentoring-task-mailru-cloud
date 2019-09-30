package com.epam.mentoring.yandex.disk.tests;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.model.creator.TestDataReader;
import com.epam.mentoring.yandex.disk.pages.LoginPage;
import com.epam.mentoring.yandex.disk.pages.YandexLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass (groups = "yandexWithLogin")
    public void signIn () {
        LoginPage loginPage = new LoginPage().openPage().clickEnterCloudBtn();

        YandexLoginPage yandexLoginPage = new YandexLoginPage().fillEmail(TestDataReader.getTestData("yandex.login")).clickEnterBtn()

                                                               .fillPassword(TestDataReader.getTestData("yandex.password")).clickEnterBtn();
        yandexLoginPage.waitPageLoad("client/disk");

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
