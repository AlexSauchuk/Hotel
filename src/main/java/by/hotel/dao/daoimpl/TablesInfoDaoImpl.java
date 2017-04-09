package by.hotel.dao.daoimpl;

import by.hotel.dao.AbstractDao;
import by.hotel.dao.TablesInfoDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablesInfoDaoImpl extends AbstractDao implements TablesInfoDao{
    public List<String> getNamesTables() throws DAOException {
        Connection connection;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<String> namesTables=new ArrayList<String>();
        try {
            connection = getConnection();
            statement=connection.prepareStatement(Constants.GET_ALL_NAMES_TABLES);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                namesTables.add(resultSet.getString("Tables_in_db_hotel"));
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
}
