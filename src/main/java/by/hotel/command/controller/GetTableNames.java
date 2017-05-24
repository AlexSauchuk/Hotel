package by.hotel.command.controller;

import by.hotel.command.exception.CommandException;
import by.hotel.service.TablesInfoService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.TablesInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GetTableNames  {
    @ResponseBody
    @RequestMapping(value = "/admin_start", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView execute() throws CommandException {
        ModelAndView modelAndView = new ModelAndView();
        List<String> resultList;
        try {
            TablesInfoService service = new TablesInfoServiceImpl();
            resultList = service.getAllTablesNames();
            modelAndView.setViewName("admin");
            modelAndView.addObject("items", resultList);
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return modelAndView;
    }
}

