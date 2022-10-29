package com.company.handler;

import jakarta.servlet.ServletRequest;
import com.company.service.concretes.UserServiceManager;

public class UserVerifyHandler {
    public static boolean isUniqueUser(ServletRequest req) {
        String email = req.getParameter("email");
        UserServiceManager service = new UserServiceManager();
        return service.getAllUser().stream().noneMatch(user -> user.getEmail().equals(email));
    }
}
