package service.abstracts;

import model.User;

import java.util.List;

public interface UserService {
    User getUserByID(int id);

    List<User> getAllUser();

    void insertUser(String name, String surname, String email, String pictureURL, int age, String password);

    int findUserIdByEmail(String email);
}
