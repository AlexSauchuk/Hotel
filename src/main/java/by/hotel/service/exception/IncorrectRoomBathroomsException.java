package by.hotel.service.exception;

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
