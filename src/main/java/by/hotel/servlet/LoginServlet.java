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

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_OK);
        Controller controller = new Controller();
        boolean resp;
        resp = controller.doAction("LOGINATION" + "&" + request.getParameter("name") + "&" + request.getParameter("password"));

        if (resp){
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.print("Welcome, " + request.getParameter("name"));
            HttpSession session = request.getSession();
            session.setAttribute("name", request.getParameter("name"));
        }else {
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
