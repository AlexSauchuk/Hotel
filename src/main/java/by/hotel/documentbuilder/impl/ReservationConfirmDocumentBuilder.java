package by.hotel.documentbuilder.impl;

import by.hotel.bean.Reservation;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.service.exception.ServiceException;

public class ReservationConfirmDocumentBuilder implements DocumentBuilder<Reservation>{

    private ReservationConfirmDocumentBuilder(){}

    private static class Holder{
        private final static ReservationConfirmDocumentBuilder INSTANCE = new ReservationConfirmDocumentBuilder();
    }

    public static ReservationConfirmDocumentBuilder getInstance(){
        return Holder.INSTANCE;
    }

    public void buildDocument(Reservation reservation) throws ServiceException {

    }
}
