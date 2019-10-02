package com.epam.mentoring.yandex.disk.services;

import com.epam.mentoring.yandex.disk.blocks.FileItem;
import com.epam.mentoring.yandex.disk.model.File;
import com.epam.mentoring.yandex.disk.model.creator.FileCreator;

import static org.hamcrest.MatcherAssert.assertThat;

public interface ChecksFileItem {

    FileItem getFileItem (String uniqueName);

    default void checkFileIsVisible (String uniqueName) {
        assertThat("check file is visible", getFileItem(uniqueName).self().isDisplayed());
    }

    default void checkFileItemExists (File file, String uniqueName) {
        FileItem fileItem = getFileItem(uniqueName);
        assertThat("check that folder contains file name", FileCreator.createFileWithNameAndType(fileItem.getTitle(),fileItem.getFileType()).equals(file));
    }

    default void checkFileItemType (File file, String uniqueName) {
        assertThat("check that folder contains file type", getFileItem(uniqueName).getFileType().equals(file.getFileType()));
    }
}
