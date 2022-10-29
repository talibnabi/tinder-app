package com.company.controller.message;

import com.company.cookies.Cookies;
import com.company.freemarker.FreemarkerTemplateConfigurer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.company.model.User;
import com.company.service.concretes.MessageServiceManager;
import com.company.service.concretes.UserServiceManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class MessageServlet extends HttpServlet {
    private int cookiesToID;
    private int pathID;
    private final UserServiceManager userServiceManager = new UserServiceManager();
    private final MessageServiceManager messageServiceManager;
    private final FreemarkerTemplateConfigurer configurer;

    public MessageServlet(FreemarkerTemplateConfigurer configurer) {
        messageServiceManager = new MessageServiceManager();
        this.configurer = configurer;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        cookiesToID = Cookies.getIdFromCookies(request);
        pathID = Integer.parseInt(request.getPathInfo().replace("/", ""));
        User senderForPic = userServiceManager.getUserByID(cookiesToID);
        User receiverForPic = userServiceManager.getUserByID(pathID);
        HashMap<String, Object> data = new HashMap<>();
        try {
            data.put("messages", messageServiceManager.getAllDirectMessage(cookiesToID, pathID));
            data.put("sender", cookiesToID);
            data.put("senderPic", senderForPic);
            data.put("receiverPic", receiverForPic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        configurer.render("chat.ftl", data, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        pathID = Integer.parseInt(request.getPathInfo().replace("/", ""));
        String text = request.getParameter("message");
        cookiesToID = Cookies.getIdFromCookies(request);
        messageServiceManager.insertMessage(cookiesToID, pathID, text, System.currentTimeMillis());
        response.sendRedirect("/chat" + request.getPathInfo());
    }
}
