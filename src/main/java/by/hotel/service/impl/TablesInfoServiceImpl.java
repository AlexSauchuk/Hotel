package by.hotel.service.impl;

import by.hotel.dao.TablesInfoDao;
import by.hotel.dao.impl.TablesInfoDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.TablesInfoService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class TablesInfoServiceImpl extends AbstractService implements TablesInfoService {
    TablesInfoDao tablesInfoDao = new TablesInfoDaoImpl();
    public List<String> getAllTablesNames() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return tablesInfoDao.getNamesTables(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }
}
