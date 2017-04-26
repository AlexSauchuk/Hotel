package by.hotel.factory.impl;

import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.factory.DocumentBuilderFactory;

import java.util.HashMap;
import java.util.Map;

public final class DocumentBuilderMapper implements DocumentBuilderFactory {

    final private static Map<String, DocumentBuilder> builderMap = new HashMap();

    static {
    }

    private static class Holder{
        private final static DocumentBuilderMapper INSTANCE = new DocumentBuilderMapper();
    }

    public static DocumentBuilderMapper getInstance(){
        return DocumentBuilderMapper.Holder.INSTANCE;
    }

    public DocumentBuilder getDocumentBuilder(String documentName) {
        return builderMap.get(documentName);
    }
}
