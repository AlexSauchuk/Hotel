package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.ServiceMapper;
import by.hotel.service.exception.ServiceException;
import by.hotel.util.ParametersParser;

import java.util.Map;

public class RemoveEntity implements Command {
    public Object execute(Map<String, String[]> requestParameters) throws CommandException {
        try {
            CrudService service =  ServiceMapper.getService(requestParameters.get("tableName")[0]);
            Map<String, String[]> entityParams = ParametersParser.parseParameters(requestParameters.get("entityParams")[0]);
            service.removeEntity(service.buildEntity(entityParams));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return null;
    }
}
