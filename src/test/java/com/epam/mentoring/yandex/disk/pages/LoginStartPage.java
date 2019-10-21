package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.yandex.disk.blocks.Button;
import org.openqa.selenium.support.FindBy;

public class LoginStartPage extends AbstractPage {

    @FindBy (css = "div[class='header__actions aos-init aos-animate']> a[class='button button_login header__login-link']")
    private Button enterCloudButton;

    public LoginStartPage () {}

    public Button getEnterCloudButton () {
        waitForElementsVisible(enterCloudButton.self());
        return enterCloudButton;
    }
}
