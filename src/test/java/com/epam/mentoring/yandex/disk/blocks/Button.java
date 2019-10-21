package com.epam.mentoring.yandex.disk.blocks;


import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class Button extends BaseElement {

    private WebElement label;

    public Button (WebElement element) {
        super(element);
    }

    public void clickButton () {
        self().click();
    }
}
