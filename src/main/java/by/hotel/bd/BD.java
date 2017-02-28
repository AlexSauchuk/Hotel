package by.hotel.bd;

import resource.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BD {

    private static Connection connection;

    private  static String url = Constants.URL;
    private  static String username = Constants.USERNAME;
    private  static String password = Constants.PASSWORD;

    static{
        try{

            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.err.println("Igor ne pidogr0a connection");
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
