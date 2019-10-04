package com.epam.mentoring.yandex.disk.services.stepdefs;

import com.epam.mentoring.yandex.disk.model.File;
import com.epam.mentoring.yandex.disk.model.creator.FileCreator;
import com.epam.mentoring.yandex.disk.model.creator.UserCreator;
import com.epam.mentoring.yandex.disk.services.pages.FolderInDiskService;
import com.epam.mentoring.yandex.disk.services.pages.LoginStartService;
import com.epam.mentoring.yandex.disk.services.pages.YandexDiskService;
import com.epam.mentoring.yandex.disk.services.pages.YandexLoginService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YandexDiskStepDefs {
    private static final String FILE_NAME = "L&D ATM8 - Hometask M10 - Java.docx";

    YandexDiskService yandexDiskService;
    FolderInDiskService folderInDiskService;
    File file;

    @Given ("^I opened Yendex Disk site")
    public void iOpenedAmazonSite(){
        new LoginStartService().openPage().clickEnterYandexDisk();
        new YandexLoginService().loginUser(UserCreator.withCredentialsFromProperty());
    }

    @And ("^I search ([\\w ]+)$")
    public void iSearch(String fileName) {
        folderInDiskService = new FolderInDiskService().initializeFilesInFolder();
        file = FileCreator.createTextFileWithName(fileName);
    }


    @When ("^I open Folder page ([\\w ]+)$")
    public void iOpenItemPage(String nameFolder) {
        yandexDiskService = new YandexDiskService().initializeFoldersInDisk().clickFolder(nameFolder);

    }

    @Then ("^ Then File Item name equals ([\\w ]+)") //\\$L&D ATM(\\d+) - Hometask M(\\d+) - Java\\.docx$
    public void itemPriceIsLower$(String fileName) {
        folderInDiskService.checkFileItemExists(file, fileName);
    }
}
