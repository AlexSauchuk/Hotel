package by.hotel.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {

    private static Connection connection;

    private  static String url = Constants.URL;
    private  static String username = Constants.USERNAME;
    private  static String password = Constants.PASSWORD;

    static{
        try{
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.err.println("Database driver not found");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            throw e;
        }
    }

}
