package by.hotel.controller;

import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetEntityHeaders  {
    private static final Logger logger = LogManager.getLogger(GetEntityHeaders.class.getName());

    @ResponseBody
    @RequestMapping(value = "/get_headers", method = RequestMethod.GET, produces = "application/json")
    public Object execute(String[] tableName){
        Map<String,List<String>> resultMap = new LinkedHashMap<>();
        int tablesCount = tableName.length;
        try {
            for (int i = 0; i < tablesCount; i++){
                CrudService service =  CrudServiceMapper.getService(tableName[i]);
                resultMap.put(tableName[i], ((CrudServiceExtended)service).getAllHeaders());
            }
        }catch (ServiceException e){
            logger.error(e);
        }
        return resultMap;
    }
}
