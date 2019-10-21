package com.epam.mentoring.yandex.disk.tests;

import com.epam.mentoring.yandex.disk.services.pages.YandexDiskService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test (groups = "yandexWithLogin")
public class DragAndDropFolderTest extends BaseTest {

    YandexDiskService yandexDiskService;

    @BeforeClass
    public void dragAndDrop () {
        yandexDiskService = new YandexDiskService().initializeFoldersInDisk().dragAndDropFolder("Folder1", "Folder2");
    }

    @Test (description = "check that drag and drop for folder have done ")
    public void dragAndDropFolderHaveDone () {
        yandexDiskService.checkNotificationMessage("Folder1");
    }
}
