package by.hotel.dao;

import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;

public interface AuthDao {
    User authorisation(String email, String password, Connection connection)throws DAOException;
}
