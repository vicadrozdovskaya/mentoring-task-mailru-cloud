package com.epam.mentoring.mailru.cloud.blocks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseRow {

    private WebElement label = row().findElement(By.cssSelector(""));

    public Button (WebElement row) {
        super(row);
    }

    public void clickButton () {
        row().click();
    }
}
