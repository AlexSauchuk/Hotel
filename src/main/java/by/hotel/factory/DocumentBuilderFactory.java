package by.hotel.factory;

import by.hotel.documentbuilder.DocumentBuilder;

public interface DocumentBuilderFactory {
    DocumentBuilder getDocumentBuilder(String documentName);
}
