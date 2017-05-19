package by.hotel.service.exception;

public class IncorrectNameRoleException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectNameRoleException(){
    }

    public IncorrectNameRoleException(Exception e){
        super(e);
    }

    public IncorrectNameRoleException(String message){
        super(message);
    }

    public IncorrectNameRoleException(String message, Exception e){
        super(message, e);
    }
}
