package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectLoginException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectLoginException(){
    }

    public IncorrectLoginException(Exception e){
        super(e);
    }

    public IncorrectLoginException(String message){
        super(message);
    }

    public IncorrectLoginException(String message, Exception e){
        super(message, e);
    }
}
