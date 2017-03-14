package by.hotel.service.exception;

/**
 * Created by 1 on 28.02.2017.
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    public ServiceException(){
    }

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception e){
        super(message, e);
    }
}
