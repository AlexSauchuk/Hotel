package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.User;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.UserDocumentBuilder;
import by.hotel.service.documentservice.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.UserServiceImpl;

import java.util.Map;

public class UserDocumentBuilderService implements DocumentBuilderService{
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        User user = new UserServiceImpl().getEntity(Integer.parseInt(documentInfo.get("id")[0]));
        if(user != null) {
            DocumentBuilder userDocumentBuilder = UserDocumentBuilder.getInstance();
            return userDocumentBuilder.buildDocument(user);
        }
        return null;
    }
}
