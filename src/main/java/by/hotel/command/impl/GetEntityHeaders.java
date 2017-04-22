package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.ServiceMapper;
import by.hotel.service.exception.ServiceException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GetEntityHeaders implements Command{
    public Object execute(Map<String, String[]> requestParameters) throws CommandException {
        Map<String,List<String>> resultMap = new LinkedHashMap<String, List<String>>();
        int tablesCount = requestParameters.get("tableName").length;
        try {
            for (int i = 0; i < tablesCount; i++){
                CrudService service =  ServiceMapper.getService(requestParameters.get("tableName")[i]);
                resultMap.put(requestParameters.get("tableName")[i], ((CrudServiceExtended)service).getAllHeaders());
            }
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultMap;
    }
}
