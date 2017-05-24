package by.hotel.service.exception;

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
