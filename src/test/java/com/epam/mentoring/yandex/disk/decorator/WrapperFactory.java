package com.epam.mentoring.yandex.disk.decorator;

import com.epam.mentoring.yandex.disk.blocks.BaseElement;
import org.openqa.selenium.WebElement;

public class WrapperFactory {
    public static BaseElement createInstance (Class<BaseElement> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).
                    newInstance(element);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + clazz);
        }
    }
}
