package by.hotel.dao;

import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface TablesInfoDao {
    List<String> getNamesTables() throws DAOException;
}
