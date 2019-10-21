package com.epam.mentoring.yandex.disk.services;

import com.epam.mentoring.yandex.disk.blocks.FileItem;
import com.epam.mentoring.yandex.disk.model.File;
import com.epam.mentoring.yandex.disk.model.creator.FileCreator;
import org.openqa.selenium.WebElement;

import static com.epam.mentoring.core.HighlightingElement.highlightElement;
import static org.hamcrest.MatcherAssert.assertThat;

public interface ChecksFileItem {

    FileItem getFileItem (String uniqueName);

    default void checkFileIsVisible (String uniqueName) {
        WebElement element = getFileItem(uniqueName).self();
        highlightElement(element);
        assertThat("check file is visible", element.isDisplayed());
    }

    default void checkFileItemExists (File file, String uniqueName) {
        FileItem fileItem = getFileItem(uniqueName);
        highlightElement(fileItem.self());
        assertThat("check that folder contains file name",
                   FileCreator.createFileWithNameAndType(fileItem.getTitle(), fileItem.getFileType()).equals(file));
    }

    default void checkFileItemType (File file, String uniqueName) {
        FileItem fileItem = getFileItem(uniqueName);
        highlightElement(fileItem.self());
        assertThat("check that folder contains file type", fileItem.getFileType().equals(file.getFileType()));
    }
}
