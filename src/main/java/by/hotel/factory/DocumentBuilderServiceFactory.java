package by.hotel.factory;

import by.hotel.service.DocumentBuilderService;

public interface DocumentBuilderServiceFactory {
    DocumentBuilderService getDocumentBuilderService(String documentName);
}
