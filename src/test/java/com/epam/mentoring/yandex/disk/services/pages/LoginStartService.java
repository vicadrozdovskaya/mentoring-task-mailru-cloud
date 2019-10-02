package com.epam.mentoring.yandex.disk.services.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.pages.LoginStartPage;

public class LoginStartService {

    LoginStartPage loginStartPage;

    public LoginStartService () {this.loginStartPage = new LoginStartPage();}

    public LoginStartService clickEnterYandexDisk () {
        loginStartPage.getEnterCloudButton().clickButton();
        return this;
    }

    public LoginStartService openPage () {
        DriverSingleton.getDriver().navigate().to("https://disk.yandex.by/");
        return this;
    }
}
