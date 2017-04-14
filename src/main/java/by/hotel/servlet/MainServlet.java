package by.hotel.servlet;

import by.hotel.command.exception.CommandException;
import by.hotel.factories.commandfactory.CommandFactory;
import by.hotel.factories.commandfactory.commandfactoriesimplementation.CommandFactoryMapper;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
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
        private static final Logger logger = LogManager.getLogger(MainServlet.class.getName());

        private void doRequest(HttpServletRequest req, HttpServletResponse resp){
            try {
                String page = req.getParameter("page");
                CommandFactory commandFactory = CommandFactoryMapper.getCommandFactory(req.getParameter("action"));
                Object result = commandFactory.createCommand().execute(req.getParameter("tableName"));
                if(page != null) {
                    req.setAttribute("items", result);
                    req.getRequestDispatcher(page).forward(req,resp);
                }else {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    Gson jsonConverter = new Gson();
                    resp.getWriter().write(jsonConverter.toJson(result));
                }
            } catch (CommandException e) {
                logger.error(e);
            }catch (IOException e){
                logger.error(e);
            }catch (ServletException e){
                logger.error(e);
            }
        }

        protected void doGet(HttpServletRequest req,HttpServletResponse resp) {
            doRequest(req, resp);
        }

        protected void doPost(HttpServletRequest req,HttpServletResponse resp) {
            doRequest(req, resp);
        }

        protected void doDelete(HttpServletRequest req,HttpServletResponse resp) {
            doRequest(req, resp);
        }
}
