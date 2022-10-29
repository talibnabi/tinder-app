package com.company.controller.user;


import com.company.constants.controller.ControllerLayerConstants;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.company.service.concretes.UserServiceManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.company.matcher.MatchPassword.passwordEncoder;

public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Path path = Paths.get(ControllerLayerConstants.userRegisterServletPath);
        ServletOutputStream os;
        try {
            os = resp.getOutputStream();
            Files.copy(path, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String pictureURL = req.getParameter("picUrl");
        String age = req.getParameter("age");
        String password = req.getParameter("password");
        UserServiceManager usersDaoService = new UserServiceManager();
        usersDaoService.insertUser(name, surname, email, pictureURL, Integer.parseInt(age), passwordEncoder(password));
        resp.sendRedirect("/login/");
    }
}
