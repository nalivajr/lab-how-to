package by.bsu.fpmi.up.howto.webappsample;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    public static final String KEY_STORAGE_ATTRIBUTE_NAME = "app-context";

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("app-context", new KeyStorage());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute(KEY_STORAGE_ATTRIBUTE_NAME);
    }
}
