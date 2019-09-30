package com.epam.mentoring.yandex.disk.services.pages;

import com.epam.mentoring.yandex.disk.blocks.Folder;
import com.epam.mentoring.yandex.disk.pages.YandexDiskPage;
import com.epam.mentoring.yandex.disk.services.ChecksFolderService;

public class YandexDiskDragAndDropService implements ChecksFolderService {

    private YandexDiskPage yandexDiskPage;

    public YandexDiskDragAndDropService () {
        this.yandexDiskPage = new YandexDiskPage();
    }

    @Override
    public Folder folder () {
        return yandexDiskPage.getFolders().get(0);
    }
}
