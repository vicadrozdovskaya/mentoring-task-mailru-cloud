package com.epam.mentoring.yandex.disk.blocks;

import org.openqa.selenium.WebElement;

public class BaseRow {

    private WebElement row;

    public BaseRow (WebElement row) {
        this.row = row;
    }


    public WebElement row () {
        return row;
    }
}
