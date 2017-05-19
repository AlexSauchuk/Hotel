package by.hotel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "mainfilter",
        urlPatterns = {"/servlet"},
        initParams = @WebInitParam(name = "env", value = "dev"))
public class MainFilter implements Filter {
    final private static Map<String, Integer> rights = new HashMap();

    static {
        rights.put("ADMIN_START", 127);
        rights.put("GET_ALL", 4);
        rights.put("ADD", 16);
        rights.put("REMOVE", 32);
        rights.put("UPDATE", 64);
        rights.put("GET_ALL_HEADERS", 127);
        rights.put("CREATE_DOCUMENT", 127);
        rights.put("AUTHORIZATION", 4);
        rights.put("REGISTRATION", 4);
    }

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Integer requiredRight;
        Integer userRights;

        requiredRight = rights.get(request.getParameter("action"));
        //userRights = Integer.parseInt(request.getParameter("rights"));
        userRights = 127;
        if ((requiredRight & userRights) == requiredRight) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("errorPage").forward(request, response);
        }
    }

    public void destroy() {
        filterConfig = null;
    }

}