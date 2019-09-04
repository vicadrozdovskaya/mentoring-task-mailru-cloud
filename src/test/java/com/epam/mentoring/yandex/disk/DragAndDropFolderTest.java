package com.epam.mentoring.yandex.disk;

import com.epam.mentoring.yandex.disk.pages.YandexDiskPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "yandexWithLogin")
public class DragAndDropFolderTest extends BaseTest {

    YandexDiskPage yandexDiskPage;

    @BeforeClass
    public void dragAndDrop() {
        yandexDiskPage = new YandexDiskPage()
                .initFolders().dragAndDropFolder("Folder1", "Folder2");
    }

    @Test(description = "Login to Yandex disk")
    public void loginYandexDisk() {
        yandexDiskPage.initFolders();
        Assert.assertTrue(yandexDiskPage.getNotificationsMessage().contains("Folder1"));
    }
}
