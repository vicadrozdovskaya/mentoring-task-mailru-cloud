package com.epam.mentoring.mailru.cloud;

import com.epam.mentoring.driver.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "mailruWithLogin")
public class LoginTest extends BaseTest{
    @Test (description = "Login to Mail.ru")
    public void loginMailru () {
        Assert.assertTrue(DriverSingleton.getDriver().getCurrentUrl().contains("https://e.mail.ru/messages"));
    }
}
