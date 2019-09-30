package com.epam.mentoring.yandex.disk.services;

import com.epam.mentoring.yandex.disk.blocks.Folder;
import org.testng.Assert;

public interface ChecksFolderService {
    Folder folder();
    default void checkButtonIsVisible () {
        Assert.assertTrue(folder().self().isDisplayed(), "check folder is visible");
    }


}
