package by.hotel.servlet;

import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AdminServiceImpl;
import by.hotel.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SK on 27.03.2017.
 */
@WebServlet(urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet{

    private AdminServiceImpl admin = new AdminServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            String param = req.getParameter("table");
            if(param!=null) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                Gson jsonConverter = new Gson();
                String data  = jsonConverter.toJson(admin.getTable(param));
                resp.getWriter().write(data);
            }else {
                req.setAttribute("args", admin.getAllTablesNames());
                req.getRequestDispatcher("/Admin.jsp").forward(req, resp);
            }
        } catch (ServiceException e) {
        }
    }
}
