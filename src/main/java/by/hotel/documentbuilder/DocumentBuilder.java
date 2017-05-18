package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;

import java.io.OutputStream;

public interface DocumentBuilder<T> {
    DocumentObject buildDocument(T documentData, OutputStream outputStream) throws ServiceException;
}
