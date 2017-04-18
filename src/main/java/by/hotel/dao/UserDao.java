package by.hotel.dao;

import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.util.List;

public interface UserDao {
    List<Integer> getId() throws DAOException;

    List<User> getUsers() throws DAOException;

    void addUser(User user) throws DAOException;

    void removeUser(User user) throws DAOException;

    void updateUser(User user) throws DAOException;

    User getUser(Integer id) throws DAOException;
}
