package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RemoveEntity implements Command {
    public Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException {
        String result = null;
        try {
            CrudService service =  CrudServiceMapper.getService(requestParameters.get("tableName")[0]);
            service.removeEntity(service.buildEntity(requestParameters));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}