package by.hotel.service.impl;

import by.hotel.dao.TablesInfoDao;
import by.hotel.dao.daoimpl.TablesInfoDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.TablesInfoService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

public class TablesInfoServiceImpl implements TablesInfoService {
    TablesInfoDao tablesInfoDao = new TablesInfoDaoImpl();
    public List<String> getAllTablesNames() throws ServiceException {
        try {
            return tablesInfoDao.getNamesTables();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
