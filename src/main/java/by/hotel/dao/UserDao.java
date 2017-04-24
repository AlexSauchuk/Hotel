package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    List<String> getUserHeaders(Connection connection) throws DAOException;
    List<User> getUsers(Connection connection) throws DAOException;
    void addUser(User user, Connection connection) throws DAOException;
    void removeUser(User user, Connection connection) throws DAOException;
    void updateUser(User user, Connection connection) throws DAOException;
    User getUser(Integer id, Connection connection) throws DAOException;
    User getLastInsertedUser(Connection connection) throws DAOException;

}
