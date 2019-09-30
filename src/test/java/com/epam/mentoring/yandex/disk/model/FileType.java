package com.epam.mentoring.yandex.disk.model;

import java.util.Arrays;
import java.util.List;

public enum FileType {
    TEXT("txt", "docx", "doc"), IMAGE("png", "jpeg", "jpg");

    private List<String> values;

    FileType (String... args) {
        values = Arrays.asList(args);
    }

    public List<String> getFileTypeValues(){
        return values;
    }
}
