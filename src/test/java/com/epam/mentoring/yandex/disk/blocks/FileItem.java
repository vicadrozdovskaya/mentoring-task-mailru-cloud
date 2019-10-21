package com.epam.mentoring.yandex.disk.blocks;

import com.epam.mentoring.yandex.disk.model.FileType;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

@Getter
public class FileItem extends BaseElement {

    private WebElement icon = self().findElement(
            By.cssSelector("div>div[class='listing-item__icon-wrapper js-prevent-mouse-selection']>img"));

    private WebElement title = self().findElement(By.cssSelector("div[class='listing-item__info']>div>span"));

    private FileType fileType;
    private String extension;

    public FileItem (WebElement element) {
        super(element);
        detectFileType();
    }

    public String parseExtension () {
        String[] splitted = title.getAttribute("title").split("\\.");
        return splitted[splitted.length - 1];
    }

    public void detectFileType () {
        String type = parseExtension();
        fileType = Arrays.stream(FileType.values()).filter(value -> value.getFileTypeValues().contains(type)).findFirst().get();
    }

    public String getTitle () {
        return title.getAttribute("title");
    }
}
