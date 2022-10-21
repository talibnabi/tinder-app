package model;

import java.util.Objects;

public class User {

    private int id;
    private final String username;
    private final String password;
    private String email;
    private String pictureURL;


    public User(int id, String username, String password, String email, String pictureURL) {
        this.id = id;
        this.email = email;
        this.pictureURL = pictureURL;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) && getEmail().equals(user.getEmail()) && getPictureURL().equals(user.getPictureURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getEmail(), getPictureURL());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                '}';
    }
}
