package com.epam.mentoring.yandex.disk.model.creator;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle rb = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData (String key) {
        return rb.getString(key);
    }
}
