package by.hotel.command.controller;

import by.hotel.bean.User;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.RegistrationService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.RegistrationServiceImpl;
import by.hotel.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class Registration  {
    @ResponseBody
    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
    public Object execute(HttpServletRequest req) throws CommandException {
        Map<String, String[]> requestParams = req.getParameterMap();
        try {
            User user;
            RegistrationService registrationService = new RegistrationServiceImpl();
            CrudService userService = new UserServiceImpl();
            user = registrationService.registration((User)userService.buildEntity(requestParams));
            if (user != null){
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
