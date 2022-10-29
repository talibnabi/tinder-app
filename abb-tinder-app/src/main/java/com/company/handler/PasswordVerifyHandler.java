package com.company.handler;


import jakarta.servlet.ServletRequest;

public class PasswordVerifyHandler {
    public static boolean checkPasswordEquals(ServletRequest req) {
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("repassword");
        if (password == null && passwordRepeat == null) {
            return true;
        } else {
            assert password != null;
            return password.equals(passwordRepeat);
        }
    }
}
