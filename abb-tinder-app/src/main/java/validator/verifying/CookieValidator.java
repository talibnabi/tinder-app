package validator.verifying;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import cookies.Cookies;

public class CookieValidator {

    public static boolean checkCookies(ServletRequest req) {
        return (Cookies.getIdFromCookies(((HttpServletRequest) req)) < 1);
    }
}
