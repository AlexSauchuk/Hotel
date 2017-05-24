package by.hotel.command.controller;

import by.hotel.command.exception.CommandException;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetEntityHeaders  {
    @ResponseBody
    @RequestMapping(value = "/get_headers", method = RequestMethod.POST, produces = "application/json")
    public Object execute(HttpServletRequest req) throws CommandException {
        Map<String,List<String>> resultMap = new LinkedHashMap<String, List<String>>();
        Map<String, String[]> requestParams = req.getParameterMap();
        int tablesCount = requestParams.get("tableName").length;
        try {
            for (int i = 0; i < tablesCount; i++){
                CrudService service =  CrudServiceMapper.getService(requestParams.get("tableName")[i]);
                resultMap.put(requestParams.get("tableName")[i], ((CrudServiceExtended)service).getAllHeaders());
            }
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultMap;
    }
}
