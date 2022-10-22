import freemarker.FreemarkerTemplateConfigurer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.io.IOException;

public class ApplicationStarter {
    public static void main(String[] args) throws IOException {
        Server webServer = new Server(8099);
        ServletContextHandler webHandler = new ServletContextHandler();
        FreemarkerTemplateConfigurer engine = new FreemarkerTemplateConfigurer("./src/main/resources/template/webcontent/ftl/");

    }
}
