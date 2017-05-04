package by.hotel.documentbuilder;

import by.hotel.service.exception.ServiceException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public abstract class PdfDocumentBuilder<T> implements DocumentBuilder<T> {
    private final String FILE_PATH;

    public PdfDocumentBuilder(String filePath){
        FILE_PATH = filePath;
    }

    public final void buildDocument(T documentData) throws ServiceException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try{
            PdfReader pdfReader = new PdfReader(classLoader.getResourceAsStream(FILE_PATH));
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("E:\\lAB\\6 семестр\\СПП\\Hotel\\temp.pdf"));
            pdfStamper.setFormFlattening(true);
            final BaseFont baseFont = BaseFont.createFont("c:\\Windows\\Fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            final AcroFields form = pdfStamper.getAcroFields();
            form.addSubstitutionFont(baseFont);
            setFields(form, documentData);
            pdfStamper.close();
            pdfReader.close();
        }catch (IOException e){
            throw new ServiceException(e);
        }catch (DocumentException e) {
            throw new ServiceException(e);
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }

    protected abstract void setFields(AcroFields form, T documentData) throws DocumentException, IOException;
}
