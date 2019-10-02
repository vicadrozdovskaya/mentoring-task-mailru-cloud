package com.epam.mentoring.yandex.disk.services;

import com.epam.mentoring.yandex.disk.blocks.Folder;

import static org.hamcrest.MatcherAssert.assertThat;

public interface ChecksFolderService {
    Folder folder (String nameFolder);

    default void checkFolderIsVisible (String nameFolder) {
        assertThat("check folder is visible", folder(nameFolder).self().isDisplayed());
    }

    default void checkFolderName (String nameFolder) {
        assertThat("check folder is visible", folder(nameFolder).self().isDisplayed());
    }

}
