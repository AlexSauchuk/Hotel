package by.hotel.dao.daofactoriesimplementation;

import by.hotel.dao.DaoFactory;
import by.hotel.dao.IUserDao;
import by.hotel.dao.daoimpl.UserDao;

/**
 * Created by user1 on 16.03.2017.
 */
public class UserDaoFactory extends DaoFactory {
    public IUserDao getDaoImplementation(){
        return new UserDao();
    }
}
