package com.epam.mentoring.yandex.disk.model.creator;

import com.epam.mentoring.yandex.disk.model.File;
import com.epam.mentoring.yandex.disk.model.FileType;

public class FileCreator {
    private static final String DEFAULT_FILE_NAME = "DefaultTeatFile";

    public static File createTextFileWithName (String name) {
        return new File(name, FileType.TEXT);
    }

    public static File createTextFileWithDefaultName () {
        return new File(DEFAULT_FILE_NAME, FileType.TEXT);
    }

    public static File createImageFileWithName (String name) {
        return new File(name, FileType.IMAGE);
    }

    public static File createImageFileWithDefaultName () {
        return new File(DEFAULT_FILE_NAME, FileType.IMAGE);
    }

    public static File createFileWithNameAndType (String name, FileType type) {
        return new File(name, type);
    }

}
