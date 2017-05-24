package by.hotel.controller;

import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RemoveEntity   {
    private static final Logger logger = LogManager.getLogger(RemoveEntity.class.getName());

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = "text/plain; charset=UTF-8")
    public String execute(HttpServletRequest req){
        String result = null;
        Map<String, String[]> requestParams = req.getParameterMap();
        try {
            CrudService service =  CrudServiceMapper.getService(requestParams.get("tableName")[0]);
            service.removeEntity(service.buildEntity(requestParams));
        }catch (ServiceException e){
            logger.error(e);
            result = e.getMessage().substring(e.getMessage().lastIndexOf(":")+1);
        }
        return result;
    }
}