package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.yandex.disk.blocks.Button;
import com.epam.mentoring.yandex.disk.blocks.TextField;
import com.epam.mentoring.yandex.disk.model.User;
import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;


public class YandexLoginPage extends AbstractPage {

    private final static String BASE_URL = "https://mail.ru/login";
    //private final static By ENTER_ANOTHER_ACCOUNT = By.className();
   // private final static By LOGIN = By.className("passp-form-field__input");
    private final static By PASSWORD = By.className("passp-form-field__input");
   // private final static By SINGN_IN = By.className("passp-sign-in-button");
    @FindBy(className = "passp-account-list__sign-in-button-text")
    private Button enterAnotherAccount;
    @FindBy(className = "passp-form-field__input" )
    private TextField emailField;
    @FindBy(className = "passp-form-field__input" )
    private TextField passField;
    @FindBy(className = "passp-sign-in-button" )
    private Button enterButton;

    public YandexLoginPage () {

    }

    /*public YandexLoginPage initEnterAnotherAccount () {
        enterAnotherAccount = new Button(driver.findElement(ENTER_ANOTHER_ACCOUNT));
        return this;
    }

    public YandexLoginPage initEmailField () {
        emailField = new TextField(driver.findElement(LOGIN));
        return this;
    }

    public YandexLoginPage initPasswordField () {
        waitPageLoad("/auth/welcome");
        passField = new TextField(driver.findElement(PASSWORD));
        return this;
    }

    public YandexLoginPage initEnterBtn () {
        enterButton = new Button(driver.findElement(SINGN_IN));
        return this;
    }*/

    public YandexLoginPage fillEmail (String email) {
        emailField.fillText(email);
        return this;
    }

    public YandexLoginPage fillPassword (String password) {
        waitForElementsVisible(PASSWORD);
        passField = new TextField(driver.findElement(PASSWORD));
        passField.fillText(password);
        return this;
    }

    public YandexLoginPage clickEnterBtn () {
        enterButton.clickButton();
        return this;
    }

    public YandexLoginPage clickEnterAnotherAccountBtn () {
        enterAnotherAccount.clickButton();
        return this;
    }

    public YandexDiskPage loginUser (User user) {
        fillEmail(user.getUserName()).fillPassword(user.getUserPassword()).clickEnterBtn();
        return new YandexDiskPage();
    }

    public YandexLoginPage openPage () {
        driver.navigate().to(BASE_URL);
        return this;
    }

}
