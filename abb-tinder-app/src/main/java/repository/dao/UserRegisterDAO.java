package repository.dao;

import model.User;

public interface UserRegisterDAO extends DAO<User>{
    void register(User user);
}
