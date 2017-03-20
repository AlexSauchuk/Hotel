package by.hotel.dao.daofactoriesimplementation;

import by.hotel.dao.IUserDao;
import by.hotel.dao.daoimpl.ReceptionistDao;

/**
 * Created by user1 on 16.03.2017.
 */
public class ReceptionistDaoFactory extends UserDaoFactory {
    public IUserDao getDaoImplementation(){
        return new ReceptionistDao();
    }
}
