package by.hotel.command.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.factory.impl.DocumentBuilderMapper;
import by.hotel.service.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class CreateDocument implements Command {
    public Object execute(HttpServletRequest req, HttpServletResponse response) throws CommandException {
        Map<String, String[]> requestParams = req.getParameterMap();
        DocumentObject documentObject;
        try {
            DocumentBuilderMapper documentBuilderMapper = DocumentBuilderMapper.getInstance();
            DocumentBuilderService documentBuilderService = documentBuilderMapper.getDocumentBuilderService(requestParams.get("docname")[0]);
            documentObject = documentBuilderService.buildDocument(Integer.parseInt(requestParams.get("id")[0]), response.getOutputStream());
        }catch (ServiceException | IOException e){
            throw new CommandException(e);
        }
        return documentObject;
    }
}
