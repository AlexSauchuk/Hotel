package by.hotel.service.exception;

/**
 * Created by 1 on 03.05.2017.
 */
public class IncorrectUserEmailException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectUserEmailException(){
    }

    public IncorrectUserEmailException(Exception e){
        super(e);
    }

    public IncorrectUserEmailException(String message){
        super(message);
    }

    public IncorrectUserEmailException(String message, Exception e){
        super(message, e);
    }
}
