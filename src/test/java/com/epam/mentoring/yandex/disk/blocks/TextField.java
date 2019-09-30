package com.epam.mentoring.yandex.disk.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextField extends BaseElement {
    private WebElement label;
    private WebElement inputField = self().findElement(By.cssSelector("input"));

    public TextField(WebElement element) {
        super(element);
    }

    public void fillText(String text) {
        inputField.sendKeys(text);
    }

    public WebElement getInputField () {
        return inputField;
    }

    public void setLabel() {
        label = self().findElement(By.cssSelector("label"));
    }
}
