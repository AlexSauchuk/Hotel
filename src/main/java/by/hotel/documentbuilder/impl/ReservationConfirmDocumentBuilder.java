package by.hotel.documentbuilder.impl;

import by.hotel.bean.Reservation;
import by.hotel.bean.User;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

public class ReservationConfirmDocumentBuilder extends PdfDocumentBuilder<Reservation> {
    private ReservationConfirmDocumentBuilder(){
        super("/documents/reservation_confirm_blank.pdf");
    }

    private static class Holder{
        private final static ReservationConfirmDocumentBuilder INSTANCE = new ReservationConfirmDocumentBuilder();
    }

    public static ReservationConfirmDocumentBuilder getInstance(){
        return Holder.INSTANCE;
    }

    protected void setFields(AcroFields form, Reservation reservation) throws DocumentException, IOException{
        String fullname = getUserFullname(reservation.getUser());
        form.setField("addressee", fullname);
        form.setField("date", reservation.getDateIn().toString());
        form.setField("appeal", "Уважаемый "+ fullname);
        form.setField("date-in", reservation.getDateIn().toString());
        form.setField("date-out", reservation.getDateOut().toString());
    }

    private String getUserFullname(User user){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(user.getSurname());
        stringBuilder.append(" ");
        stringBuilder.append(user.getName());
        return stringBuilder.toString();
    }
}
