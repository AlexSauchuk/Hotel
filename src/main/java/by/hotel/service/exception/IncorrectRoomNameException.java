package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectRoomNameException  extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomNameException(){
    }

    public IncorrectRoomNameException(Exception e){
        super(e);
    }

    public IncorrectRoomNameException(String message){
        super(message);
    }

    public IncorrectRoomNameException(String message, Exception e){
        super(message, e);
    }
}
