package by.hotel.service;

import by.hotel.service.exception.ServiceException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class AbstractService {
    private static final Logger logger;
    private static HikariDataSource dataSource;

    static {
        try{
            logger = LogManager.getLogger(AbstractService.class.getName());
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
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
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

    public final Connection getConnection() throws ServiceException{
        Connection connection;
        try{
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
        return connection;
    }

    public void closeConnection(Connection connection) throws ServiceException {
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
