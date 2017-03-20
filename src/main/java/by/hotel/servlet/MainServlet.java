package by.hotel.servlet;

import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SK on 14.02.2017.
 */
@WebServlet (urlPatterns = {"/servlet"})
public class MainServlet extends HttpServlet {

/*
    static {
        try {
            Class.forName(Logger.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
*/
//    Logger log=Logger
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {

        try {
            req.setAttribute("users",new UserServiceImpl().getUsers());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
