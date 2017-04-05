package by.hotel.dao.daoimpl;

import by.hotel.bean.User;
import by.hotel.dao.AbstractDao;

import by.hotel.dao.AdminDao;
import by.hotel.dao.exception.DAOException;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by SK on 27.03.2017.
 */
public class AdminDaoImpl extends AbstractDao implements AdminDao {
    private String GET_ALL_NAMES_TABLES = "SHOW TABLES FROM hotel";
    private String GET_TABLE = "SELECT * FROM Hotel.$tableName";

    public List<String> getNamesTables() throws DAOException {
        Connection connection;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<String> namesTables=new ArrayList<String>();
        try {
            connection=getConnection();
            statement=connection.prepareStatement(GET_ALL_NAMES_TABLES);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                namesTables.add(resultSet.getString("Tables_in_hotel"));
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }finally {
            try{
                if(resultSet!=null){
                    resultSet.close();
                }
                if(statement!=null){
                    statement.close();
                }
                closeConnection();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return namesTables;
    }

    public Map<String,ArrayList<String>> getTable(String name) throws DAOException {
        Connection connection;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Map<String,ArrayList<String>> dataQuery = new LinkedHashMap<String, ArrayList<String>>();

        try {
            connection=getConnection();
            String query = GET_TABLE.replace("$tableName",name.toString());
            statement=connection.prepareStatement(query);

            resultSet=statement.executeQuery();
            int countColumns = resultSet.getMetaData().getColumnCount();

            for(int i = 1;i<=countColumns;i++) {
                Class c = Class.forName(resultSet.getMetaData().getColumnClassName(i));

                dataQuery.put(resultSet.getMetaData().getColumnLabel(i), new ArrayList<String>());
            }

            while(resultSet.next()){
                for(int i=1;i<=countColumns;i++) {
                    dataQuery.get(dataQuery.keySet().toArray()[i-1]).add(resultSet.getString(i));
                }
            }

        }catch (SQLException e){
            throw new DAOException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                if(resultSet!=null){
                    resultSet.close();
                }
                if(statement!=null){
                    statement.close();
                }
                closeConnection();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataQuery;
    }
}
