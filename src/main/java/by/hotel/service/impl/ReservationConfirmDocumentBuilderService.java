package by.hotel.service.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.Reservation;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.ReservationConfirmDocumentBuilder;
import by.hotel.service.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;

import java.io.OutputStream;

public class ReservationConfirmDocumentBuilderService implements DocumentBuilderService{
    public DocumentObject buildDocument(int idReservation, OutputStream outputStream) throws ServiceException {
        Reservation reservation = new ReservationServiceImpl().getEntity(idReservation);
        DocumentBuilder reservationConfirmDocumentBuilder = ReservationConfirmDocumentBuilder.getInstance();
        return reservationConfirmDocumentBuilder.buildDocument(reservation, outputStream);
    }
}
