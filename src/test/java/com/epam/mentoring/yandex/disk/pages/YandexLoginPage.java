package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.yandex.disk.blocks.Button;
import com.epam.mentoring.yandex.disk.blocks.TextField;
import com.epam.mentoring.yandex.disk.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


public class YandexLoginPage extends AbstractPage {

    private final static String BASE_URL = "https://mail.ru/login";
    private final static By PASSWORD = By.className("passp-form-field__input");

    @FindBy (className = "passp-account-list__sign-in-button-text")
    private Button enterAnotherAccount;
    @FindBy (className = "passp-form-field__input")
    private TextField emailField;
    @FindBy (className = "passp-form-field__input")
    private TextField passField;
    @FindBy (className = "passp-sign-in-button")
    private Button enterButton;

    public YandexLoginPage () { }

    public static String getBaseUrl () {
        return BASE_URL;
    }

    public static By getPASSWORD () {
        return PASSWORD;
    }

    public Button getEnterAnotherAccount () {
        return enterAnotherAccount;
    }

    public TextField getEmailField () {
        return emailField;
    }

    public TextField getPassField () {
        return passField;
    }

    public Button getEnterButton () {
        return enterButton;
    }

    public void updatePassField () {
        waitForElementsVisible(PASSWORD);
        this.passField = new TextField(driver.findElement(PASSWORD));
    }
}
