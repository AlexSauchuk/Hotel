package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectRoomSizeException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomSizeException(){
    }

    public IncorrectRoomSizeException(Exception e){
        super(e);
    }

    public IncorrectRoomSizeException(String message){
        super(message);
    }

    public IncorrectRoomSizeException(String message, Exception e){
        super(message, e);
    }
}
