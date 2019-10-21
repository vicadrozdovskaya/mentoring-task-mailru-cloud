package com.epam.mentoring.yandex.disk.services.pages;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.yandex.disk.blocks.Folder;
import com.epam.mentoring.yandex.disk.pages.YandexDiskPage;
import com.epam.mentoring.yandex.disk.services.ChecksFolderService;
import org.openqa.selenium.interactions.Actions;

import static com.epam.mentoring.core.HighlightingElement.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class YandexDiskService implements ChecksFolderService {

    private YandexDiskPage yandexDiskPage;

    public YandexDiskService () {
        this.yandexDiskPage = new YandexDiskPage();
    }

    public YandexDiskService initializeFoldersInDisk () {
        yandexDiskPage.initFolders();
        return this;
    }

    public YandexDiskService clickFolder (String nameFolder) {
        Folder folder = folder(nameFolder);
        highlightElement(folder.self());
        new Actions(DriverSingleton.getDriver()).doubleClick(folder.self()).perform();
        return this;
    }

    public YandexDiskService dragAndDropFolder (String nameFolderToDrop, String nameFolderInDrop) {
        Folder folderToDrop = folder(nameFolderToDrop);
        Folder folderInDrop = folder(nameFolderInDrop);
        highlightElement(folderToDrop.self());
        highlightElement(folderInDrop.self());
        new Actions(DriverSingleton.getDriver()).dragAndDrop(folderToDrop.self(), folderInDrop.self()).perform();
        unHighlightElement(folderInDrop.self());
        return this;
    }

    public void checkNotificationMessage (String message) {
        assertThat("check notification message", yandexDiskPage.getNotificationsMessage().contains(message));
    }

    @Override
    public Folder folder (String nameFolder) {
        return yandexDiskPage.getFolders().stream().filter(folder -> folder.getNameFolder().equals(nameFolder)).findFirst().get();
    }
}
