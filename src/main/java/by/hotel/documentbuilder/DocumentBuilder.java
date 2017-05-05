package by.hotel.documentbuilder;

import by.hotel.service.exception.ServiceException;

public interface DocumentBuilder<T> {
    void buildDocument(T documentData) throws ServiceException;
}
