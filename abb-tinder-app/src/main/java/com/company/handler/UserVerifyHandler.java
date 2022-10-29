package com.company.handler;

import jakarta.servlet.ServletRequest;
import com.company.service.concretes.UserServiceManager;

public class UserVerifyHandler {
    public static boolean isUniqueUser(ServletRequest req) {
        return new UserServiceManager()
                .getAllUser()
                .stream()
                .noneMatch(user -> user.getEmail().equals(req.getParameter("email")));
    }
}
