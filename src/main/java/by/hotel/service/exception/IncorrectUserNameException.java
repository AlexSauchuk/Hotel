package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
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
