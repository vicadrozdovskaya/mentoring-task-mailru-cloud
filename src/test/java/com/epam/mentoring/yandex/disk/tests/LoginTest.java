package com.epam.mentoring.yandex.disk.tests;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test(groups = "yandexWithLogin")
@Listeners (TestListener.class)
public class LoginTest extends BaseTest{
    @Test (description = "Login to Yandex disk")
    public void loginYandexDisk () {
        Assert.assertTrue(DriverSingleton.getDriver().getCurrentUrl().contains("https://disk.yandex.by/client/disk"));
    }
}
