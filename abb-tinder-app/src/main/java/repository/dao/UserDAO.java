package repository.dao;

import model.User;

import java.util.List;

public interface UserDAO extends DAO<User> {
    List<User> getAllUser();

    User getUserById(int id);
}
