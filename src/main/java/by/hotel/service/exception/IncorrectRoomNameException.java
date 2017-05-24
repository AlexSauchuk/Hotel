package by.hotel.service.exception;

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
