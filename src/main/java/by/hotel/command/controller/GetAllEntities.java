package by.hotel.command.controller;

import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class GetAllEntities  {
    @RequestMapping(value = "/get_all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object execute(String tableName) throws CommandException {
        List<?> resultList;
        try {
            CrudService service =  CrudServiceMapper.getService(tableName);
            resultList = service.getAllEntities();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}
