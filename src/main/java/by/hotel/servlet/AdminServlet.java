package by.hotel.servlet;

import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AdminServiceImpl;
import by.hotel.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by SK on 27.03.2017.
 */
@WebServlet(urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet{

    private AdminServiceImpl admin = new AdminServiceImpl();
    private UserServiceImpl user = new UserServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            String param = req.getParameter("table");
            if(param!=null) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                Gson jsonConverter = new Gson();
                String data  = jsonConverter.toJson(user.getAllEntities());
                resp.getWriter().write(data);
            }else {
                req.setAttribute("args", admin.getAllTablesNames());
                req.getRequestDispatcher("/Admin.jsp").forward(req, resp);
            }
        } catch (ServiceException e) {
        }
    }

    List<String> list = new ArrayList<String>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String param = req.getParameter("json");
            Gson jsonConverter = new Gson();
            Type type = new TypeToken<List<String>>(){}.getType();
            list =  jsonConverter.fromJson(param,type);
            req.setAttribute("args", list);
            resp.sendRedirect(req.getContextPath() + "/formAdmin.jsp");
            req.getRequestDispatcher("/formAdmin.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String param = req.getParameter("id");
            Gson jsonConverter = new Gson();
            req.getRequestDispatcher("/Admin.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }
}
