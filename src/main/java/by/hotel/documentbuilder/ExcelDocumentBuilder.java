package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ExcelDocumentBuilder<T> implements DocumentBuilder<T>{
    private final String DOCUMENT_NAME;
    private final static String MIME_TYPE = "application/vnd.ms-excel";

    public ExcelDocumentBuilder(String filename){
        DOCUMENT_NAME = filename;
    }

    public final DocumentObject buildDocument(T documentData) throws ServiceException {
        DocumentObject documentObject;
        try(HSSFWorkbook workbook = new HSSFWorkbook();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            fillDoc(workbook, documentData);
            workbook.write(byteArrayOutputStream);
            documentObject = fillDocumentObject(byteArrayOutputStream);
        }catch (IOException e){
            throw new ServiceException(e);
        }
        return documentObject;
    }

    private DocumentObject fillDocumentObject(ByteArrayOutputStream byteArrayOutputStream){
        DocumentObject documentObject = new DocumentObject();
        documentObject.setDocumentName(DOCUMENT_NAME);
        documentObject.setMimeType(MIME_TYPE);
        documentObject.setDocumentBytes(byteArrayOutputStream.toByteArray());
        return documentObject;
    }

    protected abstract void fillDoc(HSSFWorkbook workbook, T documentData) throws ServiceException;
}
