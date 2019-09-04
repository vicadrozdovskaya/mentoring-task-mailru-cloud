package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.yandex.disk.blocks.Button;
import com.epam.mentoring.yandex.disk.blocks.TextField;
import org.openqa.selenium.By;

public class YandexLoginPage extends AbstractPage {

    private final static String BASE_URL = "https://mail.ru/login";
    private final static By ENTER_ANOTHER_ACCOUNT = By.className("passp-account-list__sign-in-button-text");
    private final static By LOGIN = By.className("passp-form-field__input");
    private final static By PASSWORD = By.className("passp-form-field__input");
    private final static By SINGN_IN = By.className("passp-sign-in-button");
    private Button enterAnotherAccount;
    private TextField emailField;
    private TextField passField;
    private Button enterButton;

    public YandexLoginPage() {

    }
    public YandexLoginPage initEnterAnotherAccount() {
        enterAnotherAccount = new Button(driver.findElement(ENTER_ANOTHER_ACCOUNT));
        return this;
    }
    public YandexLoginPage initEmailField() {
        emailField = new TextField(driver.findElement(LOGIN));
        return this;
    }
    public YandexLoginPage initPasswordField() {
        waitPageLoad("/auth/welcome");
        passField = new TextField(driver.findElement(PASSWORD));
        return this;
    }
    public YandexLoginPage initEnterBtn() {
        enterButton = new Button(driver.findElement(SINGN_IN));
        return this;
    }

    public YandexLoginPage fillEmail(String email) {
        emailField.fillText(email);
        return this;
    }

    public YandexLoginPage fillPassword(String password) {
        passField.fillText(password);
        return this;
    }

    public YandexLoginPage clickEnterBtn() {
        enterButton.clickButton();
        return this;
    }
    public YandexLoginPage clickEnterAnotherAccountBtn() {
        enterAnotherAccount.clickButton();
        return this;
    }

    public YandexLoginPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

}
