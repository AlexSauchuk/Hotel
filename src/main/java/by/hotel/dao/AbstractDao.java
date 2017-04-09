package by.hotel.dao;

import by.hotel.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class AbstractDao {
    private static final Logger logger = LogManager.getLogger(AbstractDao.class.getName());

    private Connection connection;

    static {
        try{
            Class.forName(Driver.class.getName());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public final Connection getConnection() throws DAOException{
        InputStream inputStream =null;
        Properties properties=new Properties();
        try{
            Class.forName(com.mysql.jdbc.Driver.class.getName());
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/config.properties");
            properties.load(inputStream);
            connection = DriverManager.getConnection(properties.getProperty("database.URL"),properties.getProperty("database.LOGIN"),properties.getProperty("database.PASSWORD"));
        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        } finally {
            try {
                if(inputStream !=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
        return connection;
    }

    public void closeConnection() throws DAOException{
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
           throw new DAOException(e);
        }
    }

    protected void finalize(PreparedStatement statement) throws DAOException {
        try {
            if (statement != null) {
                statement.close();
            }
            closeConnection();
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
