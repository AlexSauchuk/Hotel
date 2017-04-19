package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectRoomCountException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomCountException(){
    }

    public IncorrectRoomCountException(Exception e){
        super(e);
    }

    public IncorrectRoomCountException(String message){
        super(message);
    }

    public IncorrectRoomCountException(String message, Exception e){
        super(message, e);
    }
}
