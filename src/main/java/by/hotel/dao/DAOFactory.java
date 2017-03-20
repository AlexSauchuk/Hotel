package by.hotel.dao;

import java.sql.Driver;

/**
 * Created by SK on 16.02.2017.
 */
public abstract class DaoFactory {

    static {
        try{
            Class.forName(Driver.class.getName());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
