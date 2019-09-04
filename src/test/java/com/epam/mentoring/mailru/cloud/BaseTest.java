package com.epam.mentoring.mailru.cloud;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.mailru.cloud.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;

public class BaseTest {
    protected static final ResourceBundle rb;

    static {
        rb = ResourceBundle.getBundle("login");
    }

    @BeforeClass (groups = "mailruWithLogin")
    public void signIn () {
        LoginPage loginPage = new LoginPage().openPage()
                                             .initBlocks()
                                             .clickEnterCloudBtn()
                                             .fillEmail(rb.getString("mailru.login"))
                                             .fillPassword(rb.getString("mailru.password"))
                                             .clickEnterBtn();
    }

    @BeforeClass (alwaysRun = true, description = "Start browser")
    private void initBrowser () {
        DriverSingleton.getDriver();
    }

    @AfterClass (alwaysRun = true, description = "close browser")
    public void kill () {
        DriverSingleton.closeDriver();
    }
}
