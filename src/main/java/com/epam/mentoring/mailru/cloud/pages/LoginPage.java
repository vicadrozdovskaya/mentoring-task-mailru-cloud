package com.epam.mentoring.mailru.cloud.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.mailru.cloud.blocks.Button;
import com.epam.mentoring.mailru.cloud.blocks.TextField;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

    private Button enterCloudButton;
    private TextField emailField;
    private TextField passField;
    private Button enterButton;

    public LoginPage(){
    }

    public LoginPage initBlocks(){
        enterCloudButton = new Button(DriverSingleton.getDriver().findElement(By.cssSelector("div[class='content-block__buttons']>a[data" +
                                                                                             "-action='signin-click']")));
        DriverSingleton.getDriver().switchTo().frame("x-ph__authForm__popup");
        emailField = new TextField(DriverSingleton.getDriver().findElement(By.cssSelector("label[for='ph_login']")));
        passField = new TextField(DriverSingleton.getDriver().findElement(By.cssSelector("label[for='ph_password']")));
        enterButton = new Button(DriverSingleton.getDriver().findElement(By.cssSelector("span[data-action='login']")));
        return this;
    }

    public LoginPage fillEmail(String email){
        emailField.fillText(email);
        return this;
    }
    public LoginPage fillPassword(String password){
        passField.fillText(password);
        return this;
    }
    public LoginPage clickEnterCloudBtn(){
        enterCloudButton.clickButton();
        return this;
    }

    public LoginPage clickEnterBtn(){
        enterButton.clickButton();
        return this;
    }
    public LoginPage openPage(){
        DriverSingleton.getDriver().navigate().to("https://cloud.mail.ru/");
        return this;
    }
}
