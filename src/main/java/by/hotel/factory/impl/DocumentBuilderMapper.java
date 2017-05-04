package by.hotel.factory.impl;

import by.hotel.factory.DocumentBuilderServiceFactory;
import by.hotel.service.DocumentBuilderService;
import by.hotel.service.impl.ReservationConfirmDocumentBuilderService;

import java.util.HashMap;
import java.util.Map;

public final class DocumentBuilderMapper implements DocumentBuilderServiceFactory {

    final private static Map<String, DocumentBuilderService> builderMap = new HashMap();

    static {
        builderMap.put("RESERVATION_CONFIRM", new ReservationConfirmDocumentBuilderService());
    }

    private static class Holder{
        private final static DocumentBuilderMapper INSTANCE = new DocumentBuilderMapper();
    }

    public static DocumentBuilderMapper getInstance(){
        return DocumentBuilderMapper.Holder.INSTANCE;
    }

    public DocumentBuilderService getDocumentBuilderService(String documentName) {
        return builderMap.get(documentName.toUpperCase());
    }
}
