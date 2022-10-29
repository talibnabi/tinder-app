package com.company.controller;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
public class RedirectServlet extends HttpServlet {
    private final String redirectTo;

    public RedirectServlet(String redirectTo) {
        this.redirectTo = redirectTo;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect(redirectTo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
