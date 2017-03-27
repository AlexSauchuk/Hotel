package by.hotel.database;

/**
 * Created by SK on 14.03.2017.
 */
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class main {
    private static Connection connection;
    private final static String URL = "jdbc:mysql://localhost:3306/Hotel?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true\" +\n" +
            "                    \"&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    public static void main(String[] args) {

        InputStream inputStream =null;

        try{
            connection = DriverManager.getConnection(URL,
                    USERNAME,PASSWORD);
        }catch (SQLException e) {
            e.printStackTrace();}


    }
}