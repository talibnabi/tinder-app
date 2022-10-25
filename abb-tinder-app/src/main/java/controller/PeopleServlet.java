package controller;

import cookies.Cookies;
import finding.concretes.LikedUserFindManager;
import freemarker.FreemarkerTemplateConfigurer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.concretes.UserServiceManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PeopleServlet extends HttpServlet {
    private final FreemarkerTemplateConfigurer configurer;
    private  UserServiceManager userServiceManager;

    public PeopleServlet(FreemarkerTemplateConfigurer freemarkerTemplateConfigurer) {
        this.configurer = freemarkerTemplateConfigurer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Cookies.getIdFromCookies(req);
        List<User> toLike = LikedUserFindManager.getLikedUser(id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("likedPeople", toLike);
        configurer.render("people.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        int id = userServiceManager.findUserIdByEmail(email);
        resp.sendRedirect("/chat/" + id);
    }
}
