package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;

public abstract class CvsDocumentBuilder<T> implements DocumentBuilder<T>{
    private final String DOCUMENT_NAME;
    private final static String MIME_TYPE = "text/csv";

    public CvsDocumentBuilder(String filePath){
        DOCUMENT_NAME = filePath;
    }

    public final DocumentObject buildDocument(T documentData) throws ServiceException {
        return null;
    }

    private DocumentObject fillDocumentObject(){
        DocumentObject documentObject = new DocumentObject();
        documentObject.setDocumentName(DOCUMENT_NAME);
        documentObject.setMimeType(MIME_TYPE);
        return documentObject;
    }
}
