package com.epam.mentoring.yandex.disk;

import com.epam.mentoring.driver.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "yandexWithLogin")
public class LoginTest extends BaseTest{
    @Test (description = "Login to Yandex disk")
    public void loginYandexDisk () {
        Assert.assertTrue(DriverSingleton.getDriver().getCurrentUrl().contains("https://disk.yandex.by/client/disk"));
    }
}
