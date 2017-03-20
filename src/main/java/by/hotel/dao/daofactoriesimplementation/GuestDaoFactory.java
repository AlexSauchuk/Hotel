package by.hotel.dao.daofactoriesimplementation;

import by.hotel.dao.DaoFactory;
import by.hotel.dao.IGuestDao;
import by.hotel.dao.IUserDao;
import by.hotel.dao.daoimpl.GuestDao;
import by.hotel.dao.daoimpl.UserDao;

/**
 * Created by user1 on 16.03.2017.
 */
public class GuestDaoFactory extends DaoFactory {
    public IGuestDao getDaoImplementation(){
        return new GuestDao();
    }
}
