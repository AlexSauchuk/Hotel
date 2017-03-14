package by.hotel.bd;

import resources.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SK on 21.02.2017.
 */
public class BD {

    private static Connection connection;

    private  static String url = Constants.URL;
    private  static String username = Constants.LOGIN;
    private  static String password = Constants.PASSWORD;

    static{
        try{

            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.err.println("Problem with connection");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
