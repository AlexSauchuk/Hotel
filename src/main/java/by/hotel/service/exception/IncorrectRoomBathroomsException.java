package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectRoomBathroomsException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomBathroomsException(){
    }

    public IncorrectRoomBathroomsException(Exception e){
        super(e);
    }

    public IncorrectRoomBathroomsException(String message){
        super(message);
    }

    public IncorrectRoomBathroomsException(String message, Exception e){
        super(message, e);
    }
}
