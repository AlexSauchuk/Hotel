package by.hotel.service.exception;

public class IncorrectRoomPathException  extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomPathException(){
    }

    public IncorrectRoomPathException(Exception e){
        super(e);
    }

    public IncorrectRoomPathException(String message){
        super(message);
    }

    public IncorrectRoomPathException(String message, Exception e){
        super(message, e);
    }
}
