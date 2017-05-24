package by.hotel.service.exception;

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
