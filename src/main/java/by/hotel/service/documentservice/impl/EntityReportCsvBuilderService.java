package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.documentbuilder.CsvDocumentBuilder;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.documentservice.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class EntityReportCsvBuilderService implements DocumentBuilderService{
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        CrudService service =  CrudServiceMapper.getService(documentInfo.get("entity")[0]);
        List<?> resultList = service.getAllEntities();
        DocumentBuilder<List<?>> documentBuilder = new CsvDocumentBuilder<>(documentInfo.get("entity")[0].concat(" report.csv"));
        return documentBuilder.buildDocument(resultList);
    }
}
