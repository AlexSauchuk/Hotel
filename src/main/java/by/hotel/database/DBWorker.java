package by.hotel.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by SK on 21.02.2017.
 */
public class DBWorker {

    private static Connection connection;
    private final static String URL = "jdbc:mysql://localhost:3306/Hotel?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true\" +\n" +
            "                    \"&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    static{
        InputStream inputStream =null;

        try{

            connection = DriverManager.getConnection(URL,
                    USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.err.println("Problem with connection");
        }
        finally {
            try {
                if(inputStream!=null) {
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
