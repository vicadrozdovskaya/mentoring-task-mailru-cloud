package com.epam.mentoring.yandex.disk;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.pages.LoginPage;
import com.epam.mentoring.yandex.disk.pages.YandexLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;

public class BaseTest {
    protected static final ResourceBundle rb;

    static {
        rb = ResourceBundle.getBundle("login");
    }

    @BeforeClass(groups = "yandexWithLogin")
    public void signIn() {
        LoginPage loginPage = new LoginPage().openPage().initBlocks().clickEnterCloudBtn();

        YandexLoginPage yandexLoginPage = new YandexLoginPage()
                .initEmailField()
                .fillEmail(rb.getString("yandex.login")).initEnterBtn().clickEnterBtn()
                .initPasswordField()
                .fillPassword(rb.getString("yandex.password")).initEnterBtn()
                .clickEnterBtn();
        yandexLoginPage.waitPageLoad("client/disk");

    }

    @BeforeClass(alwaysRun = true, description = "Start browser")
    private void initBrowser() {
        DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true, description = "close browser")
    public void kill() {
        DriverSingleton.closeDriver();
    }
}
