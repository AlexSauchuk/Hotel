package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AddEntity implements Command {
    public Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException {
        Object result;
        try {
            CrudService service =  CrudServiceMapper.getService(requestParameters.get("tableName")[0]);
            result = service.addEntity(service.buildEntity(requestParameters));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}
