package com.epam.mentoring.yandex.disk.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class File {
    private String name;
    private FileType fileType;

    public File (String name, FileType fileType) {
        this.name = name;
        this.fileType = fileType;
    }
}
