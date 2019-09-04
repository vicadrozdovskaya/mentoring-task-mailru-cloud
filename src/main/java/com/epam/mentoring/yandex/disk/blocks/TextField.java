package com.epam.mentoring.yandex.disk.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextField extends BaseRow {
    private WebElement label;
    private WebElement inputField;

    public TextField(WebElement row) {
        super(row);
    }

    public void fillText(String text) {
        initInputField();
        inputField.sendKeys(text);
    }

    public void initInputField() {
        inputField = row().findElement(By.cssSelector("input"));
    }

    public void setLabel() {
        label = row().findElement(By.cssSelector("label"));
    }
}
