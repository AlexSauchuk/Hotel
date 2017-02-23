import by.hotel.bd.BD;

import java.sql.Connection;

/**
 * Created by SK on 21.02.2017.
 */


public class testClass {
    public static void main(String[] args){
        BD bd = new BD();
        Connection conn = bd.getConnection();
    }
}
