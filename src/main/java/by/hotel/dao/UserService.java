package by.hotel.dao;


import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserService {

	User addUser(User user);

	boolean deleteUser(User user);

	boolean editUser(User user);

	User getUser(User user);

	ArrayList<User> getAllUsers() throws DAOException;
}