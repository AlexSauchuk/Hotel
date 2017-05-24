package by.hotel.controller;

import by.hotel.bean.User;
import by.hotel.security.MD5;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class Authorization  {
    private static final Logger logger = LogManager.getLogger(Authorization.class.getName());

    @ResponseBody
    @RequestMapping(value = "/authorization", method = RequestMethod.POST, produces = "application/json")
    public Object execute(HttpServletRequest request){
        User user = null;
        try {
            Map<String, String[]> requestParams = request.getParameterMap();
            AuthService service = new AuthServiceImpl();
            user = service.checkUser(requestParams.get("email")[0], MD5.crypt(requestParams.get("password")[0]));
            return user;
        } catch (ServiceException e) {
            logger.error(e);
        }
        return user;
    }
}
