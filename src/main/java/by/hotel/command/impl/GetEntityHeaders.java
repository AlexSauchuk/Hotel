package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.ServiceMapper;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class GetEntityHeaders implements Command{
    public Object execute(Map<String, String[]> requestParameters) throws CommandException {
        List<String> resultList;
        try {
            CrudService service =  ServiceMapper.getService(requestParameters.get("tableName")[0]);
            resultList = ((CrudServiceExtended)service).getAllHeaders();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}
