package com.company.repository.abstracts;

import com.company.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends DAO<User> {
    void insertUser(User user);

    User getUserByID(int userID) throws SQLException;

    List<User> getAllUser() throws SQLException;
    int findIdByEmail(String email);
}
