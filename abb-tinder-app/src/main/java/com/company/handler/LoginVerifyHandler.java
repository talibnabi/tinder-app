package com.company.handler;

import jakarta.servlet.ServletRequest;
import com.company.service.concretes.UserServiceManager;
import com.company.matcher.MatchPassword;

public class LoginVerifyHandler {
    public static boolean isLoginCorrect(ServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserServiceManager service = new UserServiceManager();
        if (email == null) {
            return true;
        }
        if (service.getAllUser().stream().anyMatch(user -> user.getEmail().equals(email))) {
            return service.getAllUser().stream().filter(user -> user.getEmail().equals(email))
                    .allMatch(user -> {
                        try {
                            return MatchPassword.passwordDecoder(user.getPassword()).equals(password);
                        } catch (Exception e) {
                            throw new RuntimeException("Something went wrong during checking login", e);
                        }
                    });
        } else {
            return false;
        }
    }
}
