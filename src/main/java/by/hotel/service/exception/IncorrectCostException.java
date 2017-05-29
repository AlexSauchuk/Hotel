package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectCostException extends Exception {
    private static final long serialVersionUID = 1L;
    public IncorrectCostException(){
    }

    public IncorrectCostException(Exception e){
        super(e);
    }

    public IncorrectCostException(String message){
        super(message);
    }

    public IncorrectCostException(String message, Exception e){
        super(message, e);
    }
}
