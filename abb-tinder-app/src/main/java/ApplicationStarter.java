import controller.*;
import filters.*;
import freemarker.FreemarkerTemplateConfigurer;
import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.EnumSet;

public class ApplicationStarter {
    public static void main(String[] args) throws Exception {
        Server webServer = new Server(8099);
        ServletContextHandler webHandler = new ServletContextHandler();
        FreemarkerTemplateConfigurer configurer = new FreemarkerTemplateConfigurer("./src/main/resources/template/webcontent/ftl/");

        webHandler.addServlet(new ServletHolder(new PeopleServlet(configurer)), "/list/*");
        webHandler.addServlet(new ServletHolder(new LikeServlet(configurer)), "/like");
        webHandler.addServlet(new ServletHolder(new MessageServlet(configurer)), "/chat/*");
        webHandler.addServlet(new ServletHolder(new UserLoginServlet()), "/login/*");
        webHandler.addServlet(new ServletHolder(new UserLogoutServlet()), "/logout/*");
        webHandler.addServlet(new ServletHolder(new UserRegisterServlet()), "/register/*");
        webHandler.addServlet(new ServletHolder(new RedirectServlet("/login")), "/*");
        webHandler.addServlet(new ServletHolder(new PathServlet()), "/template/*");


        webHandler.addFilter(UserRegisterFilter.class, "/register/*", EnumSet.of(DispatcherType.REQUEST));
//        webHandler.addFilter(CookiesFilter.class, "/login/*", EnumSet.of(DispatcherType.REQUEST));

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
