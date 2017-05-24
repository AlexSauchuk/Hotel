package by.hotel.service.exception;

public class IncorrectParkingSpaceLevelException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectParkingSpaceLevelException(){
    }

    public IncorrectParkingSpaceLevelException(Exception e){
        super(e);
    }

    public IncorrectParkingSpaceLevelException(String message){
        super(message);
    }

    public IncorrectParkingSpaceLevelException(String message, Exception e){
        super(message, e);
    }
}
