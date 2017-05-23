package by.hotel.documentbuilder;

import by.hotel.service.exception.ServiceException;

public abstract class CvsDocumentBuilder<T> implements DocumentBuilder<T>{
    private final String FILE_PATH;

    public CvsDocumentBuilder(String filePath){
        FILE_PATH = filePath;
    }

    public final void buildDocument(T documentData) throws ServiceException {

    }
}
