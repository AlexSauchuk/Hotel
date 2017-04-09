package by.hotel.servlet;

import by.hotel.command.exception.CommandException;
<<<<<<< HEAD
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.UserServiceImpl;
//import org.apache.logging.log4j.Logger;
=======
import by.hotel.factories.commandfactory.CommandFactory;
import by.hotel.factories.commandfactory.commandfactoriesimplementation.CommandFactoryMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = {"/servlet"})
public class MainServlet extends HttpServlet {

<<<<<<< HEAD
//    Logger log=Logger
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {

        try {
            req.setAttribute("users",new UserServiceImpl().getAllEntities());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } catch (ServiceException e) {
=======
    private static final Logger logger = LogManager.getLogger(MainServlet.class.getName());
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        try {
            CommandFactory commandFactory = CommandFactoryMapper.getCommandFactory(req.getParameter("action"));
            req.setAttribute("items",commandFactory.createCommand().execute(req.getParameter("entity")));
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        } catch (CommandException e) {
            logger.error(e);
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
        }
    }
}
