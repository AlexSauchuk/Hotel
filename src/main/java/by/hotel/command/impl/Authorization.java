package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.security.MD5;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class Authorization implements Command {
    public Object execute(HttpServletRequest req, HttpServletResponse response) throws CommandException {
        Map<String, String[]> requestParams = req.getParameterMap();
        try {
            User user;
            AuthService service = new AuthServiceImpl();
            user = service.checkUser(requestParams.get("email")[0], MD5.crypt(requestParams.get("password")[0]));
            return user;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
