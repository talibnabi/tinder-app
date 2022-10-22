import controller.redirect.RedirectServlet;
import controller.user.UserLoginServlet;
import controller.user.UserRegisterServlet;
import filters.CookiesFilter;
import filters.LoginFilterWithCookies;
import filters.UserLoginFilter;
import filters.UserRegisterFilter;
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
        FreemarkerTemplateConfigurer engine = new FreemarkerTemplateConfigurer("./src/main/resources/template/webcontent/ftl/");
        webHandler.addServlet(new ServletHolder(new UserRegisterServlet()), "/register/*");
        webHandler.addServlet(new ServletHolder(new UserLoginServlet()), "/login/*");
        webHandler.addServlet(new ServletHolder(new UserLoginServlet()), "/logout/*");
        webHandler.addServlet(new ServletHolder(new RedirectServlet("/login")), "/*");

        webHandler.addFilter(UserRegisterFilter.class, "/register/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(UserRegisterFilter.class, "/register/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(LoginFilterWithCookies.class, "/login/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(UserLoginFilter.class, "/login/*", EnumSet.of(DispatcherType.REQUEST));
        webHandler.addFilter(CookiesFilter.class, "/login/*", EnumSet.of(DispatcherType.REQUEST));
        webServer.setHandler(webHandler);
        webServer.start();
        webServer.join();
    }
}
