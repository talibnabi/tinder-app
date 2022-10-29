package com.company;

import com.company.controller.like.LikeServlet;
import com.company.controller.message.MessageServlet;
import com.company.controller.path.PathServlet;
import com.company.controller.redirect.RedirectServlet;
import com.company.controller.user.PeopleServlet;
import com.company.controller.user.UserLoginServlet;
import com.company.controller.user.UserLogoutServlet;
import com.company.controller.user.UserRegisterServlet;
import com.company.filters.*;
import com.company.freemarker.FreemarkerTemplateConfigurer;
import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.EnumSet;

import static com.company.constants.freemarker.FreemarkerLayerConstants.ftlPath;

public class ApplicationStarter {
    public static void main(String[] args) throws Exception {
        Server webServer = new Server(8098);
        ServletContextHandler webHandler = new ServletContextHandler();
        FreemarkerTemplateConfigurer configurer = new FreemarkerTemplateConfigurer(ftlPath);

        webHandler.addServlet(new ServletHolder(new PeopleServlet(configurer)), "/list/*");
        webHandler.addServlet(new ServletHolder(new LikeServlet(configurer)), "/like");
        webHandler.addServlet(new ServletHolder(new MessageServlet(configurer)), "/chat/*");
        webHandler.addServlet(new ServletHolder(new UserLoginServlet()), "/login/*");
        webHandler.addServlet(new ServletHolder(new UserLogoutServlet()), "/logout/*");
        webHandler.addServlet(new ServletHolder(new UserRegisterServlet()), "/register/*");
        webHandler.addServlet(new ServletHolder(new RedirectServlet("/login")), "/*");
        webHandler.addServlet(new ServletHolder(new PathServlet()), "/webstock/*");
        webHandler.addFilter(UserRegisterFilter.class, "/register/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(UserLoginFilter.class, "/login/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(LoginFilterWithCookies.class, "/login/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(CookiesFilter.class, "/like", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(LikedFilter.class, "/like", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(NonLikedFilter.class, "/like", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(CookiesFilter.class, "/chat/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(MessageFilter.class, "/chat/*", EnumSet.of(DispatcherType.REQUEST));
        webServer.setHandler(webHandler);
        webServer.start();
        webServer.join();
    }
}
