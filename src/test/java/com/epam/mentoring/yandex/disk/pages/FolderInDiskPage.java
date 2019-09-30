package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.yandex.disk.model.FileItem;
import com.epam.mentoring.yandex.disk.model.FileType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FolderInDiskPage extends AbstractPage {

    private final static By FILES_LIST = By.cssSelector("div[class='listing-item listing-item_theme_tile listing-item_size_m listing-item_type_file js-prevent-deselect']");
    private List<FileItem> files = new ArrayList<>();

    public FolderInDiskPage initFiles () {
        List<WebElement> webElements = driver.findElements(FILES_LIST);
        webElements.stream().forEach(webElement -> files.add(new FileItem(webElement)));
        return this;
    }

    public List<FileItem> getTextFiles () {
        return files.stream().filter(file->file.getFileType().equals(FileType.TEXT)).collect(Collectors.toList());
    }
}
