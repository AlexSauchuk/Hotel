package by.hotel.dao;

import by.hotel.dao.exception.DAOException;

import java.sql.Connection;

/**
 * Created by 1 on 14.04.2017.
 */
public interface AuthDao {
    boolean authorisation(String login, String password, Connection connection)throws DAOException;
}
