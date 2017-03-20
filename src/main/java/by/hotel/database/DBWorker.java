package by.hotel.database;

import com.mysql.jdbc.Driver;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by SK on 21.02.2017.
 */
public class DBWorker {

    private static Connection connection;

    static{
        InputStream inputStream =null;
        Properties properties=new Properties();
        try{
            Class.forName(Driver.class.getName());
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/config.properties");
            properties.load(inputStream);
            connection = DriverManager.getConnection(properties.getProperty("database.URL"),properties.getProperty("database.LOGIN"),properties.getProperty("database.PASSWORD"));
        } catch (SQLException e) {
            System.err.println("Problem with connection");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream !=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
