package by.hotel.service;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;

import java.io.OutputStream;

public interface DocumentBuilderService {
    DocumentObject buildDocument(int id, OutputStream outputStream) throws ServiceException;
}



















































































