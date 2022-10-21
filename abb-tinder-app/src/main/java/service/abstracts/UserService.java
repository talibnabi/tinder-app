package service.abstracts;

import model.User;

import java.util.List;

public interface UserService {
    User getUserByID(int id);

    List<User> getAllUser();

}
