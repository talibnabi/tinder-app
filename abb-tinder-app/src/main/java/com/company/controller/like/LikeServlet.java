package com.company.controller.like;

import com.company.cookies.Cookies;
import com.company.finding.NonLikedUserFindManager;
import com.company.freemarker.FreemarkerTemplateConfigurer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.company.model.User;
import com.company.service.concretes.LikeServiceManager;
import com.company.service.concretes.UserServiceManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LikeServlet extends HttpServlet {
    private int id;
    private int likedPersonID;
    private final LikeServiceManager likeServiceManager;
    private final UserServiceManager userServiceManager;
    private final FreemarkerTemplateConfigurer configurer;
    private List<Integer> userList = NonLikedUserFindManager.getUser(id);


    public LikeServlet(FreemarkerTemplateConfigurer configurer) {
        this.configurer = configurer;
        userServiceManager = new UserServiceManager();
        likeServiceManager = new LikeServiceManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        id = Cookies.getIdFromCookies(request);
        userList = NonLikedUserFindManager.getUser(id);
        likedPersonID = userList.get(0);
        User toLike = userServiceManager.getUserByID(likedPersonID);
        HashMap<String, Object> data = new HashMap<>();
        data.put("likedPeople", toLike);
        configurer.render("like-page.ftl", data, response);
        userList.remove(0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        id = Cookies.getIdFromCookies(req);
        userList = NonLikedUserFindManager.getUser(id);
        boolean likeBoolean = Boolean.parseBoolean(req.getParameter("like"));
        likedPersonID = userList.get(0);
        likeServiceManager.insertLike(id, likedPersonID, likeBoolean);
        resp.sendRedirect("like");
    }
}
