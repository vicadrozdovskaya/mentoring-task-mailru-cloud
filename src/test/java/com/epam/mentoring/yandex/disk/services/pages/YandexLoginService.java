package com.epam.mentoring.yandex.disk.services.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.model.User;
import com.epam.mentoring.yandex.disk.pages.YandexDiskPage;
import com.epam.mentoring.yandex.disk.pages.YandexLoginPage;

import static com.epam.mentoring.core.HighlightingElement.highlightElement;

public class YandexLoginService {

    YandexLoginPage yandexLoginPage;

    public YandexLoginService () { this.yandexLoginPage = new YandexLoginPage(); }

    public YandexLoginService fillEmail (String email) {
        yandexLoginPage.getEmailField().fillText(email);
        highlightElement(yandexLoginPage.getEmailField().self());
        return this;
    }

    public YandexLoginService fillPassword (String password) {
        yandexLoginPage.updatePassField();
        yandexLoginPage.getPassField().fillText(password);
        highlightElement(yandexLoginPage.getPassField().self());
        return this;
    }

    public YandexLoginService clickEnterBtn () {
        highlightElement(yandexLoginPage.getEnterButton().self());
        yandexLoginPage.getEnterButton().clickButton();
        return this;
    }

    public YandexLoginService clickEnterAnotherAccountBtn () {
        yandexLoginPage.getEnterAnotherAccount().clickButton();
        return this;
    }

    public YandexDiskPage loginUser (User user) {
        fillEmail(user.getUserName()).clickEnterBtn().fillPassword(user.getUserPassword()).clickEnterBtn();
        yandexLoginPage.waitPageLoad("client/disk");
        return new YandexDiskPage();
    }

    public YandexLoginService openPage () {
        DriverSingleton.getDriver().navigate().to(YandexLoginPage.getBaseUrl());
        return this;
    }
}
