package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectRoomsCountException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomsCountException(){
    }

    public IncorrectRoomsCountException(Exception e){
        super(e);
    }

    public IncorrectRoomsCountException(String message){
        super(message);
    }

    public IncorrectRoomsCountException(String message, Exception e){
        super(message, e);
    }
}
