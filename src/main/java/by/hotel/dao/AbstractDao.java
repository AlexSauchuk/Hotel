package by.hotel.dao;

import by.hotel.dao.exception.DAOException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class AbstractDao {
    private static final Logger logger = LogManager.getLogger(AbstractDao.class.getName());

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
