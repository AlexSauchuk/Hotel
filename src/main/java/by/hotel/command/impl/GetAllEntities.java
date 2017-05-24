package by.hotel.command.impl;

import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class GetAllEntities   {
    public Object execute(HttpServletRequest req, HttpServletResponse response) throws CommandException {
        List<?> resultList;
        Map<String, String[]> requestParams = req.getParameterMap();
        try {
            CrudService service =  CrudServiceMapper.getService(requestParams.get("tableName")[0]);
            resultList = service.getAllEntities();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}
