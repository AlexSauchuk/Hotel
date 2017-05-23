package by.hotel.command.controller;

import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AddEntity   {
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object execute(HttpServletRequest req) throws CommandException {
        Object result;
        try {
            Map<String, String[]> requestParams = req.getParameterMap();
            CrudService service =  CrudServiceMapper.getService(requestParams.get("tableName")[0]);
            result = service.addEntity(service.buildEntity(requestParams));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}
