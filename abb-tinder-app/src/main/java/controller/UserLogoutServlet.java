package controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("%Cookies%")) {
                    c.setPath("/");
                    c.setMaxAge(0);
                    resp.addCookie(c);
                }
            }
        }
        try {
            resp.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
