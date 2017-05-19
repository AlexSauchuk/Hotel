package by.hotel.service.exception;

public class IncorrectUserNameException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectUserNameException(){
    }

    public IncorrectUserNameException(Exception e){
        super(e);
    }

    public IncorrectUserNameException(String message){
        super(message);
    }

    public IncorrectUserNameException(String message, Exception e){
        super(message, e);
    }
}
