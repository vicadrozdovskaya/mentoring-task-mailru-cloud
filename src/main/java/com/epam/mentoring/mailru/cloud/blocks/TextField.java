package com.epam.mentoring.mailru.cloud.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextField extends BaseRow {
    private WebElement label = row().findElement(By.cssSelector(""));
    private WebElement inputField = row().findElement(By.cssSelector("input"));

    public TextField (WebElement row) {
        super(row);
    }

    public void fillText (String text) {
        inputField.sendKeys(text);
    }
}
