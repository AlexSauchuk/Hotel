package by.hotel.command;

import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AllEntity {
    public Object execute(HttpServletRequest req) throws CommandException {
        Object result;
        try {
            CrudService service =  CrudServiceMapper.getService(req.getParameterMap().get("tableName")[0]);
            result = service.addEntity(service.buildEntity(req.getParameterMap()));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}
