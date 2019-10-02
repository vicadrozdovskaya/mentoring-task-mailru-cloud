package com.epam.mentoring.yandex.disk.model;

import java.util.Objects;

public class File {
    private String name;
    private FileType fileType;

    public File (String name, FileType fileType) {
        this.name = name;
        this.fileType = fileType;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public FileType getFileType () {
        return fileType;
    }

    public void setFileType (FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return name.equals(file.name) && fileType == file.fileType;
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, fileType);
    }

    @Override
    public String toString () {
        return "File{" + "name='" + name + '\'' + ", fileType=" + fileType + '}';
    }
}
