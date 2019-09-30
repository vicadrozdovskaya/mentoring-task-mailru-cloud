package com.epam.mentoring.yandex.disk.services.pages;

import com.epam.mentoring.yandex.disk.model.FileItem;
import com.epam.mentoring.yandex.disk.pages.FolderInDiskPage;
import com.epam.mentoring.yandex.disk.services.ChecksFileItem;

public class FolderInDiskService implements ChecksFileItem {

    private FolderInDiskPage folderInDiskPage;


    @Override
    public FileItem getFileItem (String uniqueName) {
        return folderInDiskPage.getTextFiles().stream().filter(item -> item.getTitle().equals(uniqueName)).findFirst().get();
    }
}
