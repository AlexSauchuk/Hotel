package by.hotel.service.exception;

import java.text.ParseException;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectDateException extends Exception {
    private static final long serialVersionUID = 1L;
    public IncorrectDateException(){
    }

    public IncorrectDateException(Exception e){
        super(e);
    }

    public IncorrectDateException(String message){
        super(message);
    }

    public IncorrectDateException(String message, Exception e){
        super(message, e);
    }
}
