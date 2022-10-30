package com.company.controller.user;

import com.company.cookies.Cookies;
import com.company.finding.LikedUserFindManager;
import com.company.freemarker.FreemarkerTemplateConfigurer;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.company.model.User;
import com.company.service.concretes.UserServiceManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet
public class PeopleServlet extends HttpServlet {
    private final FreemarkerTemplateConfigurer configurer;
    private UserServiceManager userServiceManager;

    public PeopleServlet(FreemarkerTemplateConfigurer freemarkerTemplateConfigurer) {
        this.configurer = freemarkerTemplateConfigurer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Cookies.getIdFromCookies(req);
        System.out.println(id);
        List<User> toLike = LikedUserFindManager.getUser(id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("likedPeople", toLike);
        configurer.render("people-list.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        int id = userServiceManager.findUserIdByEmail(email);
        resp.sendRedirect("/chat/" + id);
    }
}
