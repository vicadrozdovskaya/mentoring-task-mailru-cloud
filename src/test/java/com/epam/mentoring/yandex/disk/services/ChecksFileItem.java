package com.epam.mentoring.yandex.disk.services;

import com.epam.mentoring.yandex.disk.model.FileItem;

import static org.hamcrest.MatcherAssert.assertThat;

public interface ChecksFileItem {

    FileItem getFileItem (String uniqueName);

    default void checkFileIsVisible (String uniqueName) {
        assertThat("check file is visible", getFileItem(uniqueName).self().isDisplayed());
    }

    default void checkFileItemExists (FileItem fileItem, String uniqueName) {
        assertThat("check that folder contains fileItem", getFileItem(uniqueName).equals(fileItem));
    }
}
