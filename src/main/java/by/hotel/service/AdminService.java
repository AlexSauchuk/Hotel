package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SK on 27.03.2017.
 */
public interface AdminService {
    List<String> getAllTablesNames() throws ServiceException;
    Map<String,ArrayList<String>> getTable(String name) throws ServiceException;
}
