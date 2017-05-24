package by.hotel.service.exception;

public class IncorrectDiscountNameException extends Exception {
    private static final long serialVersionUID = 1L;
    public IncorrectDiscountNameException(){
    }

    public IncorrectDiscountNameException(Exception e){
        super(e);
    }

    public IncorrectDiscountNameException(String message){
        super(message);
    }

    public IncorrectDiscountNameException(String message, Exception e){
        super(message, e);
    }
}
