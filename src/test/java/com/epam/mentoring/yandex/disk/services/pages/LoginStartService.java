package com.epam.mentoring.yandex.disk.services.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.pages.LoginStartPage;

import static com.epam.mentoring.core.HighlightingElement.highlightElement;

public class LoginStartService {

    LoginStartPage loginStartPage;

    public LoginStartService () {this.loginStartPage = new LoginStartPage();}

    public LoginStartService clickEnterYandexDisk () {
        highlightElement(loginStartPage.getEnterCloudButton().self());
        loginStartPage.getEnterCloudButton().clickButton();
        return this;
    }

    public LoginStartService openPage () {
        DriverSingleton.getDriver().navigate().to("https://disk.yandex.by/");
        return this;
    }
}
