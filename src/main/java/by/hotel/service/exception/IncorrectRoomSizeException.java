package by.hotel.service.exception;

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
