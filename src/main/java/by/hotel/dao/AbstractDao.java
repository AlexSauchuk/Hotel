package by.hotel.dao;

import by.hotel.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static by.hotel.dao.constants.Constants.GET_LAST_INSERT_ID;

public abstract class AbstractDao {
    private static final Logger logger = LogManager.getLogger(AbstractDao.class.getName());

    public int getLastInsertedId(Connection connection) throws DAOException{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result = 0;
        try {
            statement = connection.prepareStatement(GET_LAST_INSERT_ID);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = resultSet.getInt("LAST_INSERT_ID()");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return result;
    }

    public void closeStatement(Statement statement, ResultSet resultSet) throws DAOException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
