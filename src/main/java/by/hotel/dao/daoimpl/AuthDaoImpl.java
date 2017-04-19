package by.hotel.dao.daoimpl;

import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.AuthDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 1 on 14.04.2017.
 */
public class AuthDaoImpl extends AbstractDao implements AuthDao {
    public boolean authorisation(String login, String password) throws DAOException{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(Constants.AUTR_USER);
            statement = fillStatement(statement, login,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            closeConnection(connection, statement, resultSet);
        }
        return false;
    }

    private PreparedStatement fillStatement(PreparedStatement statement, String login, String password) throws SQLException {
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }
}
