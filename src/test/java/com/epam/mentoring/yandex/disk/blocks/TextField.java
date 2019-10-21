package com.epam.mentoring.yandex.disk.blocks;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class TextField extends BaseElement {
    private WebElement label;
    private WebElement inputField = self().findElement(By.cssSelector("input"));

    public TextField (WebElement element) {
        super(element);
    }

    public void fillText (String text) {
        inputField.sendKeys(text);
    }

}
