package by.hotel.documentbuilder.impl;

import by.hotel.bean.RoomType;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

public class RoomTypeDocumentBuilder extends PdfDocumentBuilder<RoomType>{
    private RoomTypeDocumentBuilder(){
        super("/documents/room_type_blank.pdf", "Room type.pdf");
    }

    private static class Holder{
        private final static RoomTypeDocumentBuilder INSTANCE = new RoomTypeDocumentBuilder();
    }

    public static RoomTypeDocumentBuilder getInstance(){
        return RoomTypeDocumentBuilder.Holder.INSTANCE;
    }


    @Override
    protected void setFields(AcroFields form, RoomType documentData) throws DocumentException{
        try {
            form.setField("rooms_count", Integer.toString(documentData.getRoomsCount()));
            form.setField("beds_count", Integer.toString(documentData.getBedsCount()));
            form.setField("cost", Float.toString(documentData.getCostPerDay()));
            form.setField("bathrooms_count", Integer.toString(documentData.getBathroomsCount()));
            form.setField("size", Integer.toString(documentData.getSize()));
        }catch (IOException e){
            throw new DocumentException(e);
        }
    }
}
