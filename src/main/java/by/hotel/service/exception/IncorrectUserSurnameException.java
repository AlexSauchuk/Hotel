package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectUserSurnameException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectUserSurnameException(){
    }

    public IncorrectUserSurnameException(Exception e){
        super(e);
    }

    public IncorrectUserSurnameException(String message){
        super(message);
    }

    public IncorrectUserSurnameException(String message, Exception e){
        super(message, e);
    }
}
