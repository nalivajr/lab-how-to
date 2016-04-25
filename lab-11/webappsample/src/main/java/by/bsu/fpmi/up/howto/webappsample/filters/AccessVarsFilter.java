package by.bsu.fpmi.up.howto.webappsample.filters;

import by.bsu.fpmi.up.howto.webappsample.ContextListener;
import by.bsu.fpmi.up.howto.webappsample.KeyStorage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/variables")
public class AccessVarsFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    @SuppressWarnings("unchecked")
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if ( (request instanceof HttpServletRequest) == false) {
            return;
        }
        String sessionId = ((HttpServletRequest) request).getSession().getId();
        String tokenFromParam = request.getParameter("token");
        KeyStorage keyStorage = ((KeyStorage) request.getServletContext().getAttribute(ContextListener.KEY_STORAGE_ATTRIBUTE_NAME));
        boolean hasSessionOrToken = keyStorage.checkByToken(tokenFromParam) || keyStorage.checkBySession(sessionId);
        if (!hasSessionOrToken) {
            ((HttpServletResponse) response).sendError(403, "Unauthorized");
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() { }
}
