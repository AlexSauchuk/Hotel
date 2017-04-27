package by.hotel.dao;

import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;

/**
 * Created by 1 on 14.04.2017.
 */
public interface AuthDao {
    User authorisation(String login, String password, Connection connection)throws DAOException;
}
