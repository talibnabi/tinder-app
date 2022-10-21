package repository.dao;

import model.User;

public interface UserLoginDAO extends DAO<User> {
    User login(String username, String password);
}
