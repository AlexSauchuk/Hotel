package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RemoveEntity implements Command {
    public Object execute(HttpServletRequest req, HttpServletResponse response) throws CommandException {
        String result = null;
        Map<String, String[]> requestParams = req.getParameterMap();
        try {
            CrudService service =  CrudServiceMapper.getService(requestParams.get("tableName")[0]);
            service.removeEntity(service.buildEntity(requestParams));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}