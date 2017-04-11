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
    private static final Logger logger;
    private static HikariDataSource dataSource;

    static {
        try{
            logger = LogManager.getLogger(AbstractDao.class.getName());
            Class.forName(Driver.class.getName());
            initConnectionPool();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static void initConnectionPool(){
        InputStream inputStream =null;
        Properties properties=new Properties();
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/config.properties");
            properties.load(inputStream);
            dataSource = new HikariDataSource( new HikariConfig(properties));
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            try {
                if(inputStream !=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    public final Connection getConnection() throws DAOException{
        Connection connection;
        try{
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return connection;
    }

    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws DAOException {
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
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
