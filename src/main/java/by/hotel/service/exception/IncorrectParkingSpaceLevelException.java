package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
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
