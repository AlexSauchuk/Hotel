package by.hotel.service.impl;

import by.hotel.dao.CrudDao;
import by.hotel.dao.daoimpl.CrudDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.DatabaseService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by user1 on 29.03.2017.
 */
public class DatabaseServiceImpl implements DatabaseService {
    CrudDao crudDao = new CrudDaoImpl();
    public List<String> getAllTablesNames() throws ServiceException {
        try {
            return crudDao.getNamesTables();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
