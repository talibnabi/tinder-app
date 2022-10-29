package com.company.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private final String name;
    private final String surname;
    private final String email;
    private final String picURL;
    private final int age;
    private final String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", picURL='" + picURL + '\'' +
                ", age=" + age +
                '}';
    }

}
