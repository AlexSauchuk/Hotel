package by.hotel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/checkUser"})
public class LoginServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/*        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_OK);
        Controller controller = new Controller();
        boolean resp;
        resp = controller.doAction("LOGINATION" + "&" + request.getParameter("name") + "&" + request.getParameter("password"));

        if (resp){
            request.getRequestDispatcher("test.jsp").include(request, response);
            out.print("Welcome, " + request.getParameter("name"));
            HttpSession session = request.getSession();
            session.setAttribute("name", request.getParameter("name"));
        }else {
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("checkUser.html").include(request, response);
        }
        out.close();*/
    }
}
