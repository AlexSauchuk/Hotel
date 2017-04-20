package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.ServiceMapper;
import by.hotel.service.exception.ServiceException;

import java.util.Map;

public class AddEntity implements Command {
    public Object execute(Map<String, String[]> requestParameters) throws CommandException {
        Object result;
        try {
            CrudService service =  ServiceMapper.getService(requestParameters.get("tableName")[0]);
            result = service.addEntity(service.buildEntity(requestParameters));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}
