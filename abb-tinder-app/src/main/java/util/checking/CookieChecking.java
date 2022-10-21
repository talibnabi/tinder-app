package util.checking;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import util.cookies.Cookies;

public class CookieChecking {

    public static boolean checkCookies(ServletRequest req) {
        return (Cookies.getIdFromCookies(((HttpServletRequest) req)) < 1);
    }
}
