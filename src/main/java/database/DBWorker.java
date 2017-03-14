package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static resources.Constants.LOGIN;
import static resources.Constants.PASSWORD;
import static resources.Constants.URL;

public class DBWorker {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBWorker() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
