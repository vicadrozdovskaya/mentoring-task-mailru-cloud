package com.epam.mentoring.yandex.disk.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Folder extends BaseRow {

    WebElement nameFolder;

    public Folder(WebElement row) {
        super(row);
    }

    public void initNameFolder() {
        nameFolder = row().findElement(By.xpath("following-sibling::div/div/span"));
    }

    public String getNameFolder() {
        return nameFolder.getText();
    }
}
