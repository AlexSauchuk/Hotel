package by.hotel.documentbuilder;

import by.hotel.service.exception.ServiceException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;

public abstract class PdfDocumentBuilder<T> implements DocumentBuilder<T> {
    private final String FILE_PATH;
    private static Logger logger;

    public PdfDocumentBuilder(String filePath){
        FILE_PATH = filePath;
        logger = LogManager.getLogger(PdfDocumentBuilder.class.getName());
    }

    public final void buildDocument(T documentData) throws ServiceException {
        PdfReader pdfReader = null;
        PdfStamper pdfStamper = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try{
            pdfReader = new PdfReader(classLoader.getResourceAsStream(FILE_PATH));
            pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("E:\\lAB\\6 семестр\\СПП\\Hotel\\temp.pdf"));
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
    }

    protected abstract void setFields(AcroFields form, T documentData) throws DocumentException, IOException;
}
