package by.hotel.service.exception;

public class IncorrectRoomPhoneNumberException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomPhoneNumberException(){
    }

    public IncorrectRoomPhoneNumberException(Exception e){
        super(e);
    }

    public IncorrectRoomPhoneNumberException(String message){
        super(message);
    }

    public IncorrectRoomPhoneNumberException(String message, Exception e){
        super(message, e);
    }
}
