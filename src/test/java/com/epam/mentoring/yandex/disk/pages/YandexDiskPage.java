package com.epam.mentoring.yandex.disk.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.blocks.Folder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class YandexDiskPage extends AbstractPage {
    private final static By FOLDER_LIST = By.className("listing-item__icon_resource_dir");
    private final static By NOTIFICATION_MESSAGE = By.className("notifications__text");
    private List<Folder> folders = new ArrayList<>();
    private WebElement notificationsMessage;

    public YandexDiskPage initFolders () {
        List<WebElement> webElements = driver.findElements(FOLDER_LIST);
        webElements.stream().forEach(webElement -> folders.add(new Folder(webElement)));
        // folders.stream().forEach(folder -> folder.initNameFolder());
        //Folder folder = Folder.class.getDeclaredConstructor((WebElement)webElements.get(0)).newInstance();
        //folders.stream().forEach(folder -> folder.initNameFolder());
        return this;
    }

    public YandexDiskPage dragAndDropFolder (String nameFolderToDrop, String nameFolderInDrop) {
        Folder folderToDrop = folders.stream().filter(folder -> folder.getNameFolder().equals(nameFolderToDrop)).findFirst().get();
        Folder folderInDrop = folders.stream().filter(folder -> folder.getNameFolder().equals(nameFolderInDrop)).findFirst().get();
        new Actions(driver).dragAndDrop(folderToDrop.self(), folderInDrop.self()).perform();
        return this;
    }

    public String getNotificationsMessage () {
        waitForElementsVisible(NOTIFICATION_MESSAGE);
        notificationsMessage = driver.findElement(NOTIFICATION_MESSAGE);
        return notificationsMessage.getText();
    }

    public YandexDiskPage clickFolder (String nameFolder) {
        new Actions(DriverSingleton.getDriver()).doubleClick(
                folders.stream().filter(folder -> folder.getNameFolder().equals(nameFolder)).findFirst().get().self()).perform();
        return this;
    }

    public List<Folder> getFolders () {
        return folders;
    }

}
