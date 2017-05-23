package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.ReservationRoom;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.ReservationVoucherDocumentBuilder;
import by.hotel.service.documentservice.DocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.ReservationRoomServiceImpl;

import java.util.List;
import java.util.Map;

public class ReservationVoucherBuilderService implements DocumentBuilderService{
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        List<ReservationRoom> reservationRooms = new ReservationRoomServiceImpl()
                .getReservationRoomByReservation(Integer.parseInt(documentInfo.get("id")[0]));
        if(reservationRooms != null){
            DocumentBuilder documentBuilder = ReservationVoucherDocumentBuilder.getInstance();
            return documentBuilder.buildDocument(reservationRooms);
        }
        return null;
    }
}
