package by.hotel.servlet;

import by.hotel.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_OK);
        Controller controller = new Controller();
        boolean resp;
        resp = controller.doAction("REGISTRATION" + "&" + request.getParameter("name") + "&" + request.getParameter("password"));

        if (!resp){
            request.getRequestDispatcher("registration.jsp").include(request, response);
            out.print("Sorry, this username is not available!");
        }else {
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.print("You have successfully signed up!");
        }
        out.close();
















//        Map<String, Object> pageVariables = new HashMap<>();
//        pageVariables.put("email", name == null ? "" : name);
//        pageVariables.put("password", password == null ? "" : password);

        //     response.getWriter().println(PageGenerator.getPage("authresponse.txt", pageVariables));
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
