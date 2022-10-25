package model;

import java.util.Objects;

public class User {

    private final String name;
    private final String surname;
    private final String email;
    private final String pictureURL;
    private final int age;
    private final String password;

    public User(String name, String surname, String email, String pictureURL, int age, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pictureURL = pictureURL;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPictureURL() {
        return pictureURL;
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
        return getAge() == user.getAge() && getName().equals(user.getName()) && getSurname().equals(user.getSurname()) && getEmail().equals(user.getEmail()) && getPictureURL().equals(user.getPictureURL()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getEmail(), getPictureURL(), getAge(), getPassword());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                ", age=" + age +
                '}';
    }

}
