package com.epam.mentoring.yandex.disk.tests;

import com.epam.mentoring.yandex.disk.pages.FolderInDiskPage;
import com.epam.mentoring.yandex.disk.pages.YandexDiskPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class FilesInFolderTest extends BaseTest {
    FolderInDiskPage folderInDiskPage;

    @BeforeClass
    public void addFilesInFolder () {
        YandexDiskPage yandexDiskPage = new YandexDiskPage().initFolders().clickFolder("Text");
        folderInDiskPage = new FolderInDiskPage().initFiles();
    }

    @Test (description = "Login to Yandex disk")
    public void loginYandexDisk () {
        assertThat("Folder has 2 text files " + folderInDiskPage.getTextFiles().size() , folderInDiskPage.getTextFiles().size() == 2);
    }
}
