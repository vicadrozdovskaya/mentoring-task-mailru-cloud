package com.epam.mentoring.yandex.disk.services.pages;

import com.epam.mentoring.yandex.disk.blocks.FileItem;
import com.epam.mentoring.yandex.disk.pages.FolderInDiskPage;
import com.epam.mentoring.yandex.disk.services.ChecksFileItem;

public class FolderInDiskService implements ChecksFileItem {

    private FolderInDiskPage folderInDiskPage;

    public FolderInDiskService () {
        this.folderInDiskPage = new FolderInDiskPage();
    }

    public FolderInDiskService initializeFilesInFolder(){
        folderInDiskPage.initFiles();
        return this;
    }

    @Override
    public FileItem getFileItem (String uniqueName) {
        return folderInDiskPage.getFileItems().stream().filter(item -> item.getTitle().equals(uniqueName)).findFirst().get();
    }
}
