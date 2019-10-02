package com.epam.mentoring.yandex.disk.tests;

import com.epam.mentoring.yandex.disk.model.File;
import com.epam.mentoring.yandex.disk.model.creator.FileCreator;
import com.epam.mentoring.yandex.disk.services.pages.FolderInDiskService;
import com.epam.mentoring.yandex.disk.services.pages.YandexDiskService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilesInFolderTest extends BaseTest {
    private static final String FILE_NAME = "L&D ATM8 - Hometask M10 - Java.docx";

    YandexDiskService yandexDiskService;
    FolderInDiskService folderInDiskService;
    File file;

    @BeforeClass
    public void enterInFolderWithFiles () {
        yandexDiskService = new YandexDiskService().initializeFoldersInDisk().clickFolder("Text");
        folderInDiskService = new FolderInDiskService().initializeFilesInFolder();
        file = FileCreator.createTextFileWithName(FILE_NAME);
    }

    @Test (description = "file is visible in folder")
    public void fileItemIsVisible () {
        folderInDiskService.checkFileIsVisible(FILE_NAME);
    }

    @Test (description = "file exists in folder")
    public void fileExistsInFolderInYandexDisk () {
        folderInDiskService.checkFileItemExists(file, FILE_NAME);
    }

    @Test (description = "file exists in folder")
    public void fileWithTextTypeExistsInFolderInYandexDisk () {
        folderInDiskService.checkFileItemType(file, FILE_NAME);
    }
}
