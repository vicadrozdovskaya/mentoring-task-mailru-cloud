package com.epam.mentoring.yandex.disk.services;

import com.epam.mentoring.yandex.disk.blocks.Button;
import org.testng.Assert;

public interface ChecksButtonService {
    Button button();

    default void checkButtonIsVisible () {
        Assert.assertTrue(button().self().isDisplayed(),"check button is visible");
    }
}
