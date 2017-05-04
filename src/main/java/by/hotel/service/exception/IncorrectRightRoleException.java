package by.hotel.service.exception;

/**
 * Created by 1 on 20.04.2017.
 */
public class IncorrectRightRoleException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRightRoleException(){
    }

    public IncorrectRightRoleException(Exception e){
        super(e);
    }

    public IncorrectRightRoleException(String message){
        super(message);
    }

    public IncorrectRightRoleException(String message, Exception e){
        super(message, e);
    }
}
