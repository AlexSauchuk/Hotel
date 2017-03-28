package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.ServiceMapper;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by 1 on 28.02.2017.
 */
public class GetAllEntities implements Command {
    public Object execute(String request) throws CommandException {
        List<?> resultList;
        try {
            String[] requestParams = request.split("&");
            CrudService service =  ServiceMapper.getService(requestParams[0]);
            resultList = service.getAllEntities();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}
