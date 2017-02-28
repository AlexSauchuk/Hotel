package by.hotel.bd;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SK on 21.02.2017.
 */
public class BD {

    private static Connection connection;

    private final static String URL = "jdbc:mysql://localhost:3306/Hotel?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true\" +\n" +
            "                    \"&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    static{
        try{

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.err.println("Igor ne pidor connection");
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
