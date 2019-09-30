package com.epam.mentoring.yandex.disk.services;

import com.epam.mentoring.yandex.disk.model.FileItem;

import static org.hamcrest.MatcherAssert.assertThat;

public interface ChecksFileItem {

    FileItem fileItem ();

    default void checkFileIsVisible () {
        assertThat("check file is visible", fileItem().self().isDisplayed());
    }

    default void checkFileItemExists(FileItem fileItem){
        assertThat("check that folder contains fileItem", fileItem().equals(fileItem));
    }
}
