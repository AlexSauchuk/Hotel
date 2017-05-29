package by.hotel.dao.exception;

/**
 * Created by 1 on 28.02.2017.
 */
public class DAOException extends Exception {
    private static final long serialVersionUID = 1L;
    public DAOException(){
    }

    public DAOException(Exception e){
        super(e);
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message, Exception e){
        super(message, e);
    }
}
