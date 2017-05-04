package by.hotel.command.impl;

import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.factory.impl.DocumentBuilderMapper;
import by.hotel.service.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CreateDocument implements Command {
    public Object execute(Map<String, String[]> requestParameters, HttpServletRequest req) throws CommandException {
        try {
            DocumentBuilderMapper documentBuilderMapper = DocumentBuilderMapper.getInstance();
            DocumentBuilderService documentBuilderService = documentBuilderMapper.getDocumentBuilderService(requestParameters.get("docname")[0]);
            documentBuilderService.buildDocument(Integer.parseInt(requestParameters.get("id")[0]));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return null;
    }
}
