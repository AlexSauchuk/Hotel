package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectSexException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectSexException(){
    }

    public IncorrectSexException(Exception e){
        super(e);
    }

    public IncorrectSexException(String message){
        super(message);
    }

    public IncorrectSexException(String message, Exception e){
        super(message, e);
    }
}
