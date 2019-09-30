package com.epam.mentoring.yandex.disk.blocks;


import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    private WebElement label;

    public Button (WebElement element) {
        super(element);
    }

    public void clickButton () {
        self().click();
    }
}
