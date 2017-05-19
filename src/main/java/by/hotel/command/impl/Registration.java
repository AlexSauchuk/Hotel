package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.AuthService;
import by.hotel.service.CrudService;
import by.hotel.service.RegistrationService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;
import by.hotel.service.impl.RegistrationServiceImpl;
import by.hotel.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class Registration implements Command {
    public Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException {
        try {
            User user;
            RegistrationService registrationService = new RegistrationServiceImpl();
            CrudService userService = new UserServiceImpl();
            user = registrationService.registration((User)userService.buildEntity(requestParameters));
            if (user != null){
                HttpSession session = req.getSession(true);
                session.setAttribute("rights",getRights(user));
                return user;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return null;
    }

    public static String getRights(User user){
        StringBuilder rights = new StringBuilder();
        rights.append(user.getRole().getUpdate());
        rights.append(user.getRole().getDelete());
        rights.append(user.getRole().getInsert());
        rights.append(user.getRole().getCreate());
        rights.append(user.getRole().getSelect());
        rights.append(user.getRole().getDrop());
        rights.append(user.getRole().getGrant());
        return rights.toString();
    }
}
