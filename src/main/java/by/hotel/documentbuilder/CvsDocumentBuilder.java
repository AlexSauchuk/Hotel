package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;

import java.io.OutputStream;

public abstract class CvsDocumentBuilder<T> implements DocumentBuilder<T>{
    private final String BLANK_PATH;

    public CvsDocumentBuilder(String filePath){
        BLANK_PATH = filePath;
    }

    public final DocumentObject buildDocument(T documentData, OutputStream outputStream) throws ServiceException {
        return null;
    }
}
