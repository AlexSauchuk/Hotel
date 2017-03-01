package by.hotel.servlet;

import by.hotel.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SK on 14.02.2017.
 */
@WebServlet (urlPatterns = {"/servlet"})
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        Controller controller=new Controller();

        req.setAttribute("attributeName","Hello");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);

        //String test = req.getAttribute("name").toString();
//        req.getRequestDispatcher("/webapp/index.jsp").forward(req,resp);

    }
}
