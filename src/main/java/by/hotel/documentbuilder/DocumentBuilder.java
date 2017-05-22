package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;

public interface DocumentBuilder<T> {
    DocumentObject buildDocument(T documentData) throws ServiceException;
}
