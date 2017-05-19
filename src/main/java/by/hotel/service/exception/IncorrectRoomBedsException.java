package by.hotel.service.exception;

public class IncorrectRoomBedsException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomBedsException(){
    }

    public IncorrectRoomBedsException(Exception e){
        super(e);
    }

    public IncorrectRoomBedsException(String message){
        super(message);
    }

    public IncorrectRoomBedsException(String message, Exception e){
        super(message, e);
    }
}
