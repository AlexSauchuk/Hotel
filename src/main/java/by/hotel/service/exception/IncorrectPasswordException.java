package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectPasswordException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectPasswordException(){
    }

    public IncorrectPasswordException(Exception e){
        super(e);
    }

    public IncorrectPasswordException(String message){
        super(message);
    }

    public IncorrectPasswordException(String message, Exception e){
        super(message, e);
    }
}
