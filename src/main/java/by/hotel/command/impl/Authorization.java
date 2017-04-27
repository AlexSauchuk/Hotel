package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.dao.AuthDao;
import by.hotel.dao.impl.UserDaoImpl;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;

import java.util.Map;

/**
 * Created by 1 on 26.04.2017.
 */
public class Authorization implements Command {
    public Object execute(Map<String, String[]> requestParameters) throws CommandException {
        try {
            AuthService service = new AuthServiceImpl();
              service.checkUser(requestParameters.get("login")[0],requestParameters.get("password")[0]);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return null;
    }
}
