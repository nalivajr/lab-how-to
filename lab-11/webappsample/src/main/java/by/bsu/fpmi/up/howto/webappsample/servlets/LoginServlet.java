package by.bsu.fpmi.up.howto.webappsample.servlets;

import by.bsu.fpmi.up.howto.webappsample.ContextListener;
import by.bsu.fpmi.up.howto.webappsample.KeyStorage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASS = "pass";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter(PARAM_NAME_LOGIN);
        String pass = req.getParameter(PARAM_NAME_PASS);

        if (userName.equals("sergey") && pass.equals("123")) {
            String token = UUID.randomUUID().toString();
            String sessionId = req.getSession().getId();
            ((KeyStorage) getServletContext().getAttribute(ContextListener.KEY_STORAGE_ATTRIBUTE_NAME)).storeToken(sessionId, token);
            resp.getOutputStream().println(token);
        } else {
            resp.getOutputStream().println("Invalid username/password");
        }
    }
}
