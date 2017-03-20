package by.hotel.dao.daofactoriesimplementation;

import by.hotel.dao.DaoFactory;
import by.hotel.dao.IAdministratorDao;
import by.hotel.dao.daoimpl.ManagerDao;

/**
 * Created by user1 on 16.03.2017.
 */
public class ManagerDaoFactory extends DaoFactory {
    public IAdministratorDao getDaoImplementation(){
        return new ManagerDao();
    }
}
