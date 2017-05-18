package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.OutputStream;

public abstract class ExcelDocumentBuilder<T> implements DocumentBuilder<T>{
    private final String FILE_PATH;

    public ExcelDocumentBuilder(String filePath){
        FILE_PATH = filePath;
    }

    public final DocumentObject buildDocument(T documentData, OutputStream outputStream) throws ServiceException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report");
        return null;
    }
}
