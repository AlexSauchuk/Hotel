package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.TablesInfoService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.TablesInfoServiceImpl;

import java.util.List;
import java.util.Map;

public class GetTableNames implements Command {
    public Object execute(Map<String, String[]> requestParameters) throws CommandException {
        List<String> resultList;
        try {
            TablesInfoService service = new TablesInfoServiceImpl();
            resultList = service.getAllTablesNames();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}

