package by.hotel.dao;

import by.hotel.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SK on 27.03.2017.
 */
public interface AdminDao  {
    List<String> getNamesTables() throws DAOException;
    Map<String,ArrayList<String>> getTable(String name) throws DAOException;
}
