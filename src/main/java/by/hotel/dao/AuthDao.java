package by.hotel.dao;

import by.hotel.dao.exception.DAOException;

/**
 * Created by 1 on 14.04.2017.
 */
public interface AuthDao {
    boolean authorisation(String login, String password)throws DAOException;
}
