package com.company.util;

import com.company.service.concretes.UserServiceManager;

import java.sql.Connection;

import static com.company.datasource.ConnectionToDB.getConnection;


public class DBOperation {
    public static final Connection connection = getConnection();
    public static int getUserIdByEmailFromDB(String email, UserServiceManager userServiceManager) {
        return userServiceManager.findUserIdByEmail(email);
    }
}
