package com.epam.mentoring.yandex.disk.blocks;


import org.openqa.selenium.WebElement;

public class Button extends BaseRow {

    private WebElement label;

    public Button (WebElement row) {
        super(row);
    }

    public void clickButton () {
        row().click();
    }
}
