package by.hotel.service.exception;

public class IncorrectRoomAdditionalInfoException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomAdditionalInfoException(){
    }

    public IncorrectRoomAdditionalInfoException(Exception e){
        super(e);
    }

    public IncorrectRoomAdditionalInfoException(String message){
        super(message);
    }

    public IncorrectRoomAdditionalInfoException(String message, Exception e){
        super(message, e);
    }
}
