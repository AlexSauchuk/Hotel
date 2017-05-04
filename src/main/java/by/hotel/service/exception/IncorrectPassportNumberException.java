package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectPassportNumberException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectPassportNumberException(){
    }

    public IncorrectPassportNumberException(Exception e){
        super(e);
    }

    public IncorrectPassportNumberException(String message){
        super(message);
    }

    public IncorrectPassportNumberException(String message, Exception e){
        super(message, e);
    }
}
