package com.company.controller.user;

import com.company.constants.controller.ControllerLayerConstants;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.company.service.concretes.UserServiceManager;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.company.util.DBOperation.getUserIdByEmailFromDB;

@WebServlet
public class UserLoginServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Path path = Paths.get(ControllerLayerConstants.userLoginServletPath);
        ServletOutputStream os;
        try {
            os = resp.getOutputStream();
            Files.copy(path, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String email = req.getParameter("email");
        UserServiceManager userServiceManager = new UserServiceManager();
        int uid = getUserIdByEmailFromDB(email, userServiceManager);
        Cookie c = new Cookie("%Cookies%", String.valueOf(uid));
        c.setPath("/");
        resp.addCookie(c);
        resp.sendRedirect("/list/");
    }
}
