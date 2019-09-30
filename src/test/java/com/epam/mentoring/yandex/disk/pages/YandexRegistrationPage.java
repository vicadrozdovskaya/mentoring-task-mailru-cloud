package com.epam.mentoring.yandex.disk.pages;

import org.openqa.selenium.By;

public class YandexRegistrationPage extends AbstractPage {

    private static final By ENTER_LINK = By.cssSelector("registration__auth-link");

    public YandexRegistrationPage clickEnterLink(){
        driver.findElement(ENTER_LINK).click();
        return this;
    }
}
