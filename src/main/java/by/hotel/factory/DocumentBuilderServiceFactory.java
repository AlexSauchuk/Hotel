package by.hotel.factory;

import by.hotel.service.documentservice.DocumentBuilderService;

public interface DocumentBuilderServiceFactory {
    DocumentBuilderService getDocumentBuilderService(String documentName);
}
