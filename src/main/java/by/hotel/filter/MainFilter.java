package by.hotel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 24.04.2017.1
 */
@WebFilter(filterName = "mainfilter",
        urlPatterns = {"/servlet"},
        initParams = @WebInitParam(name = "env", value = "dev"))
public class MainFilter implements Filter
{
    final private static Map<String, Integer> rights = new HashMap();
    static {
        rights.put("ADMIN_START",127);
        rights.put("GET_ALL",8);
    }
    private FilterConfig filterConfig = null;

    public void init (FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
    }

    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);
        session.setAttribute("rights","127");//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Integer requiredRight = rights.get(request.getParameter("action"));
        Integer userRights = Integer.parseInt((String)session.getAttribute("rights"));

        if( (requiredRight & userRights)  == requiredRight ){
            chain.doFilter(request, response);
        }else{
            request.getRequestDispatcher("tut.by").forward(request, response);
        }

    }

    public void destroy()
    {
        filterConfig = null;
    }

}