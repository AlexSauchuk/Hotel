package by.hotel.service.impl;

import by.hotel.dao.daoimpl.AdminDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AdminService;
import by.hotel.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SK on 27.03.2017.
 */
public class AdminServiceImpl implements AdminService {

    private AdminDaoImpl admin = new AdminDaoImpl();

    public List<String> getAllTablesNames() throws ServiceException {
        try {
            return admin.getNamesTables();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public Map<String,ArrayList<String>> getTable(String name) throws ServiceException {
        try {
             return admin.getTable(name);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
