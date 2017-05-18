package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public abstract class PdfDocumentBuilder<T> implements DocumentBuilder<T> {
    private final String TEMPLATE_PATH, DOCUMENT_NAME;
    private static Logger logger;

    public PdfDocumentBuilder(String templatePath, String documentName){
        TEMPLATE_PATH = templatePath;
        DOCUMENT_NAME = documentName;
        logger = LogManager.getLogger(PdfDocumentBuilder.class.getName());
    }

    public final DocumentObject buildDocument(T documentData, OutputStream outputStream) throws ServiceException {
        DocumentObject documentObject = null;
        PdfReader pdfReader = null;
        PdfStamper pdfStamper = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try{
            pdfReader = new PdfReader(classLoader.getResourceAsStream(TEMPLATE_PATH));
            pdfStamper = new PdfStamper(pdfReader, outputStream);
            pdfStamper.setFormFlattening(true);
            final BaseFont baseFont = BaseFont.createFont("c:\\Windows\\Fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            final AcroFields form = pdfStamper.getAcroFields();
            form.addSubstitutionFont(baseFont);
            setFields(form, documentData);
        }catch (IOException | DocumentException e){
            throw new ServiceException(e);
        }finally {
            try {
                if(pdfStamper != null){
                    documentObject = fillDocumentObject();
                    pdfStamper.close();
                }
            }catch (DocumentException | IOException e){
                logger.error(e);
            }finally {
                if (pdfReader != null){
                    pdfReader.close();
                }
            }
        }
        return documentObject;
    }

    protected abstract void setFields(AcroFields form, T documentData) throws DocumentException, IOException;

    private DocumentObject fillDocumentObject(){
        DocumentObject documentObject = new DocumentObject();
        documentObject.setDocumentName(DOCUMENT_NAME);
        return documentObject;
    }
}
