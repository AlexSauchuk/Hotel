package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.ServiceMapper;
import by.hotel.service.exception.ServiceException;

public class UpdateEntity implements Command {
    public boolean execute(String request) throws CommandException {
        try {
            String[] requestParams = request.split("&");
            CrudService service =  ServiceMapper.getService(requestParams[0]);
            service.updateEntity(new User());
        }catch (Exception e){
            throw new CommandException(e);
        }
        return false;
    }
}
