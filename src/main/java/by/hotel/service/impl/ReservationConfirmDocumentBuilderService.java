package by.hotel.service.impl;

import by.hotel.bean.Reservation;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.ReservationConfirmDocumentBuilder;
import by.hotel.service.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;

public class ReservationConfirmDocumentBuilderService implements DocumentBuilderService{
    public void buildDocument(int idReservation) throws ServiceException {
        Reservation reservation = new ReservationServiceImpl().getEntity(idReservation);
        DocumentBuilder reservationConfirmDocumentBuilder = ReservationConfirmDocumentBuilder.getInstance();
        reservationConfirmDocumentBuilder.buildDocument(reservation);
    }
}
