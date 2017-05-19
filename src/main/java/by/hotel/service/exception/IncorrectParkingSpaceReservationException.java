package by.hotel.service.exception;

public class IncorrectParkingSpaceReservationException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectParkingSpaceReservationException(){
    }

    public IncorrectParkingSpaceReservationException(Exception e){
        super(e);
    }

    public IncorrectParkingSpaceReservationException(String message){
        super(message);
    }

    public IncorrectParkingSpaceReservationException(String message, Exception e){
        super(message, e);
    }
}
