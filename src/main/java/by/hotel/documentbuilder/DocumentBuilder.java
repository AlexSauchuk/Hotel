package by.hotel.documentbuilder;

import by.hotel.service.exception.ServiceException;

public interface DocumentBuilder {
    void buildDocument() throws ServiceException;
}
