package com.company.cookies;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class Cookies {
    public static int getIdFromCookies(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        int id = 0;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("%Cookies%")) {
                    id = Integer.parseInt(c.getValue());
                }
            }
        }
        return id;
    }
}
