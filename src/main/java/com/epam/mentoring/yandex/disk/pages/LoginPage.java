package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.blocks.Button;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    private final static By ENTER_CLOUD_BUTTON = By.cssSelector("div[class='header__actions aos-init aos-animate']> a[class='button button_login header__login-link']");
    private Button enterCloudButton;


    public LoginPage() {
    }

    public LoginPage initBlocks() {
        enterCloudButton = new Button(DriverSingleton.getDriver().findElement(ENTER_CLOUD_BUTTON));
        return this;
    }



    public LoginPage clickEnterCloudBtn() {
        enterCloudButton.clickButton();
        return this;
    }


    public LoginPage openPage() {
        DriverSingleton.getDriver().navigate().to("https://disk.yandex.by/");
        return this;
    }
}
