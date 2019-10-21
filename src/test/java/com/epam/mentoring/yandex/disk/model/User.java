package com.epam.mentoring.yandex.disk.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private String userName;
    private String userPassword;

    public User (String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
