package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.blocks.Button;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy (css = "div[class='header__actions aos-init aos-animate']> a[class='button button_login header__login-link']")
    private Button enterCloudButton;


    public LoginPage () {
    }

    public LoginPage clickEnterCloudBtn () {
        enterCloudButton.clickButton();
        return this;
    }


    public LoginPage openPage () {
        DriverSingleton.getDriver().navigate().to("https://disk.yandex.by/");
        return this;
    }
}
