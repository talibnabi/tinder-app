package com.company.model;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class User {

    private final String name;
    private final String surname;
    private final String email;
    private final String picURL;
    private final int age;
    private final String password;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPicURL() {
        return picURL;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getAge() == user.getAge() && getName().equals(user.getName()) && getSurname().equals(user.getSurname()) && getEmail().equals(user.getEmail()) && getPicURL().equals(user.getPicURL()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getEmail(), getPicURL(), getAge(), getPassword());
    }

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
