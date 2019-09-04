package com.epam.mentoring.mailru.cloud.blocks;

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
