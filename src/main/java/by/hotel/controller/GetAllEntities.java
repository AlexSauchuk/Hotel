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

import java.util.List;


@Controller
public class GetAllEntities  {
    private static final Logger logger = LogManager.getLogger(GetAllEntities.class.getName());

    @RequestMapping(value = "/get_all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object execute(String tableName){
        List<?> resultList = null;
        try {
            CrudService service =  CrudServiceMapper.getService(tableName);
            resultList = service.getAllEntities();
        }catch (ServiceException e){
            logger.error(e);
        }
        return resultList;
    }
}
