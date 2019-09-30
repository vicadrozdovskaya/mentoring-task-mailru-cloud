package com.epam.mentoring.yandex.disk.blocks;

import org.openqa.selenium.WebElement;

public class BaseElement {

    private WebElement element;

    public BaseElement (WebElement element) {
        this.element = element;
    }


    public WebElement self () {
        return element;
    }
}
