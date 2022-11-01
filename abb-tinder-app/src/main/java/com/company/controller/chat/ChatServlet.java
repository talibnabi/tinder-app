package com.company.controller.chat;

import com.company.cookies.Cookies;
import com.company.freemarker.FreemarkerTemplateConfigurer;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.company.model.User;
import com.company.service.concretes.ChatServiceManager;
import com.company.service.concretes.UserServiceManager;
import lombok.SneakyThrows;

import java.sql.SQLException;
import java.util.HashMap;

@WebServlet
public class ChatServlet extends HttpServlet {
    private int cookiesToID;
    private int pathID;
    private final UserServiceManager userServiceManager = new UserServiceManager();
    private final ChatServiceManager messageServiceManager;
    private final FreemarkerTemplateConfigurer configurer;

    public ChatServlet(FreemarkerTemplateConfigurer configurer) {
        messageServiceManager = new ChatServiceManager();
        this.configurer = configurer;
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        cookiesToID = Cookies.getIdFromCookies(request);
        System.out.println("cookies id: "+cookiesToID);
        String path=request.getPathInfo().replace("/", "");
        pathID = Integer.parseInt(path);
        System.out.println("path id :"+pathID);
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

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        pathID = Integer.parseInt(request.getPathInfo().replace("/", ""));
        String text = request.getParameter("message");
        cookiesToID = Cookies.getIdFromCookies(request);
        messageServiceManager.insertMessage(cookiesToID, pathID, text, System.currentTimeMillis());
        response.sendRedirect("/chat" + request.getPathInfo());
    }
}
