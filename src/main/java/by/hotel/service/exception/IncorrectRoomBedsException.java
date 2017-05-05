package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
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
