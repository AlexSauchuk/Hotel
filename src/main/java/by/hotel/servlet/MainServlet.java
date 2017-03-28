package by.hotel.servlet;

import by.hotel.command.exception.CommandException;
import by.hotel.factories.commandfactory.CommandFactory;
import by.hotel.factories.commandfactory.commandfactoriesimplementation.CommandFactoryMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = {"/servlet"})
public class MainServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(MainServlet.class.getName());
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        try {
            CommandFactory commandFactory = CommandFactoryMapper.getCommandFactory(req.getParameter("action"));
            req.setAttribute("items",commandFactory.createCommand().execute(req.getParameter("entity")));
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        } catch (CommandException e) {
            logger.error(e);
        }
    }
}
