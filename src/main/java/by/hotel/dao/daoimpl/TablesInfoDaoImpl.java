package by.hotel.dao.daoimpl;

import by.hotel.dao.AbstractDao;
import by.hotel.dao.TablesInfoDao;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.GET_ALL_NAMES_TABLES;

public class TablesInfoDaoImpl extends AbstractDao implements TablesInfoDao{
    public List<String> getNamesTables() throws DAOException {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<String> namesTables=new ArrayList<String>();
        try {
            connection = getConnection();
            statement=connection.prepareStatement(GET_ALL_NAMES_TABLES);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                namesTables.add(resultSet.getString("Tables_in_db_hotel"));
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }finally {
            closeConnection(connection, statement, resultSet);
        }
        return namesTables;
    }
}
