package by.hotel.dao.daofactoriesimplementation;

import by.hotel.dao.IAdministratorDao;
import by.hotel.dao.daoimpl.AdministratorDao;

/**
 * Created by user1 on 16.03.2017.
 */
public class AdministratorDaoFactory extends ManagerDaoFactory {
    public IAdministratorDao getDaoImplementation(){
        return new AdministratorDao();
    }
}
