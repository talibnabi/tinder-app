package com.company.handler;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import com.company.cookies.Cookies;

public class CookieVerifyHandler {

    public static boolean checkCookies(ServletRequest req) {
        return Cookies.getIdFromCookies((HttpServletRequest) req) < 1;
    }
}
