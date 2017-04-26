package by.hotel.dao.impl;

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
    public List<String> getNamesTables(Connection connection) throws DAOException {
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<String> namesTables=new ArrayList<String>();
        try {
            statement=connection.prepareStatement(GET_ALL_NAMES_TABLES);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                namesTables.add(resultSet.getString("Tables_in_db_hotel"));
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }finally {
            closeStatement(statement, resultSet);
        }
        return namesTables;
    }
}
