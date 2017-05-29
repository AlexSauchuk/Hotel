package by.hotel.documentbuilder.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReservationVoucherDocumentBuilder extends PdfDocumentBuilder<List<ReservationRoom>>{
    private ReservationVoucherDocumentBuilder(){
        super("/documents/reservation_voucher_blank.pdf", "Reservation voucher.pdf");
    }

    private static class Holder{
        private final static ReservationVoucherDocumentBuilder INSTANCE = new ReservationVoucherDocumentBuilder();
    }

    public static ReservationVoucherDocumentBuilder getInstance(){
        return Holder.INSTANCE;
    }

    @Override
    protected void setFields(AcroFields form, List<ReservationRoom> documentData) throws DocumentException{
        try {
            int daysCount = getDaysCount(documentData.get(0).getReservation().getDateIn().getTime(),
                    documentData.get(0).getReservation().getDateOut().getTime());
            form.setField("reservation_id", Integer.toString(documentData.get(0).getReservation().getId()));
            form.setField("date-in", getTime(documentData.get(0).getReservation().getDateIn()));
            form.setField("date-out", getTime(documentData.get(0).getReservation().getDateOut()));
            form.setField("user_name", documentData.get(0).getReservation().getUser().getUserFullname());
            form.setField("reservation_info", getReservationInfo(documentData, daysCount));
            form.setField("total_cost", getTotalCost(documentData, daysCount));
        }catch (IOException e){
            throw new DocumentException(e);
        }
    }

    private String getTime(Date date){
        return new SimpleDateFormat("EEEE, dd MMM yyy").format(date);
    }

    private String getReservationInfo(List<ReservationRoom> documentData, int daysCount){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getNightTitle(daysCount));
        stringBuilder.append(", ");
        stringBuilder.append(documentData.size() + " номер");
        return stringBuilder.toString();
    }

    private int getDaysCount(long dateInMilsec, long dateOutMilsec){
        return (int) ((dateOutMilsec - dateInMilsec) / (24 * 60 * 60 * 1000));
    }

    private String getTotalCost(List<ReservationRoom> documentInfo, int daysCount){
        int result = 0;
        for(ReservationRoom reservationRoom: documentInfo){
            result += reservationRoom.getReservation().getCostAdditionalServices();
            result += reservationRoom.getRoom().getRoomType().getCostPerDay() * daysCount;
        }
        return Integer.toString(result);
    }

    private String getNightTitle(int nightCount){
        final int mod = nightCount % 10;
        if(nightCount >= 11 && nightCount <= 14){
            return nightCount + " ночей";
        }
        switch (mod){
            case 1: return nightCount + " ночь";
            case 2:
            case 3:
            case 4: return nightCount + " ночи";
            default: return nightCount + " ночей";
        }
    }
}
