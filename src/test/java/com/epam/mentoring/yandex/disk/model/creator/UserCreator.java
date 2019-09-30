package com.epam.mentoring.yandex.disk.model.creator;

import com.epam.mentoring.yandex.disk.model.User;

public class UserCreator {
    private static final String USER_LOGIN = "yandex.login";
    private static final String USER_PASSWORD = "yandex.password";

    public static User withCredentialsFromProperty () {
        return new User(TestDataReader.getTestData(USER_LOGIN), TestDataReader.getTestData(USER_PASSWORD));
    }

    public static User withEmptyUserName () {
        return new User((""), TestDataReader.getTestData(USER_PASSWORD));
    }

    public static User withEmptyUserPassword () {
        return new User(TestDataReader.getTestData(USER_LOGIN), (""));
    }
}
