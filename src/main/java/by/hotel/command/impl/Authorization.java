package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.dao.AuthDao;
import by.hotel.dao.impl.UserDaoImpl;
import by.hotel.security.MD5;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static by.hotel.command.impl.Registration.getRights;

public class Authorization implements Command {
    public Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException {
        try {
            User user;
            AuthService service = new AuthServiceImpl();
            user = service.checkUser(requestParameters.get("email")[0], MD5.crypt(requestParameters.get("password")[0]));
            return user;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
