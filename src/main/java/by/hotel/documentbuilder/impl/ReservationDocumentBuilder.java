package by.hotel.documentbuilder.impl;

import by.hotel.dao.exception.DAOException;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.service.AbstractService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;

public class ReservationDocumentBuilder extends AbstractService implements DocumentBuilder{

    public void buildDocument() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
        }catch (Exception e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }
}
