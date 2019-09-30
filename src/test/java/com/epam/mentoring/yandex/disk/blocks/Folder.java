package com.epam.mentoring.yandex.disk.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Folder extends BaseElement {

    WebElement nameFolder = self().findElement(By.xpath("following-sibling::div/div/span"));

    public Folder(WebElement element) {
        super(element);
    }

    public String getNameFolder() {
        return nameFolder.getText();
    }
}
