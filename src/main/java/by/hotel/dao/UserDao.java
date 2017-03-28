package by.hotel.dao;

import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user1 on 16.03.2017.
 */
public interface UserDao {
    List<User> getUsers() throws DAOException;
    void addUser(User user) throws DAOException;
    void removeUser(User user) throws DAOException;
    void updateUser(User user) throws DAOException;
}
