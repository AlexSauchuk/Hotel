package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class GetAllEntities implements Command {
    public Object execute(Map<String, String[]> requestParameters) throws CommandException {
        List<?> resultList;
        try {
            CrudService service =  CrudServiceMapper.getService(requestParameters.get("tableName")[0]);
            resultList = service.getAllEntities();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}
