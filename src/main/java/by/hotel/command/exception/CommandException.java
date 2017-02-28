package by.hotel.command.exception;

/**
 * Created by 1 on 28.02.2017.
 */
public class CommandException extends Exception{
    private static final long serialVersionUID = 1L;
    public CommandException(){
    }

    public CommandException(Exception e){
        super(e);
    }

    public CommandException(String message){
        super(message);
    }

    public CommandException(String message, Exception e){
        super(message, e);
    }
}
