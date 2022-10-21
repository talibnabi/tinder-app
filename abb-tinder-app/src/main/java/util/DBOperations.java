package util;

import service.concretes.UserServiceManager;

import java.sql.Connection;

import static db.ConnectionToDB.getConnection;

public class DBOperations {
    public static final Connection connection = getConnection();

    public static int getUserIdByEmailFromDB(String email, UserServiceManager userServiceManager) {
        return userServiceManager.findUserIdByEmail(email);
    }
}
