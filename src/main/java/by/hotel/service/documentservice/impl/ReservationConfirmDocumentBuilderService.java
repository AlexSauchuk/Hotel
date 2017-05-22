package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.Reservation;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.ReservationConfirmDocumentBuilder;
import by.hotel.service.documentservice.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.ReservationServiceImpl;

import java.util.Map;

public class ReservationConfirmDocumentBuilderService implements DocumentBuilderService{
    public DocumentObject buildDocument(Map<String, String[]> documentParams) throws ServiceException {
        Reservation reservation = new ReservationServiceImpl().getEntity(Integer.parseInt(documentParams.get("id")[0]));
        if(reservation != null) {
            DocumentBuilder reservationConfirmDocumentBuilder = ReservationConfirmDocumentBuilder.getInstance();
            return reservationConfirmDocumentBuilder.buildDocument(reservation);
        }
        return null;
    }
}
