package by.hotel.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        FileInputStream fileInputStream=null;
        try{
            fileInputStream=new FileInputStream("src/main/java/resources/databaseConstants.properties");
            Properties properties=new Properties();
            properties.load(fileInputStream);
            connection = DriverManager.getConnection(properties.getProperty("URL"),properties.getProperty("LOGIN"),properties.getProperty("PASSWORD"));
        } catch (SQLException e) {
            System.err.println("Problem with connection");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileInputStream!=null) {
                    fileInputStream.close();
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
