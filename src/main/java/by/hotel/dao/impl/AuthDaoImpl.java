package by.hotel.dao.impl;

import by.hotel.dao.AbstractDao;
import by.hotel.dao.AuthDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDaoImpl extends AbstractDao implements AuthDao {
    public boolean authorisation(String login, String password, Connection connection) throws DAOException{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(Constants.AUTH_USER);
            statement = fillStatement(statement, login,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            closeStatement(statement, resultSet);
        }
        return false;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, String login, String password) throws SQLException {
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }
}
