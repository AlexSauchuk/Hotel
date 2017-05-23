package by.hotel.documentbuilder.impl;

import by.hotel.bean.Room;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

public class RoomDocumentBuilder extends PdfDocumentBuilder<Room>{
    private RoomDocumentBuilder(){
        super("/documents/room_blank.pdf", "Room.pdf");
    }

    private static class Holder{
        private final static RoomDocumentBuilder INSTANCE = new RoomDocumentBuilder();
    }

    public static RoomDocumentBuilder getInstance(){
        return RoomDocumentBuilder.Holder.INSTANCE;
    }


    @Override
    protected void setFields(AcroFields form, Room documentData) throws DocumentException{
        try {
            form.setField("name", documentData.getName());
            form.setField("floor", Integer.toString(documentData.getFloor()));
            form.setField("phone_number", documentData.getPhone());
        }catch (IOException e){
            throw new DocumentException(e);
        }
    }
}
