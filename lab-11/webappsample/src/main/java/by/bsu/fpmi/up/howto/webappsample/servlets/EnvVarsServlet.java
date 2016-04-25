package by.bsu.fpmi.up.howto.webappsample.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/variables")
public class EnvVarsServlet extends HttpServlet {

    private static final String PARAM_NAME_VAR = "varname";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String var = req.getParameter(PARAM_NAME_VAR);
        resp.getOutputStream().println(String.format("Var %s is %s", var, System.getenv(var)));
    }
}
