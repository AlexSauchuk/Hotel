package by.hotel.service.impl;


import by.hotel.bean.User;
import by.hotel.dao.daoimpl.UserDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.IUserService;
import by.hotel.service.exception.ServiceException;

import java.util.ArrayList;

public class UserServiceImpl implements IUserService {

	public UserDao userDao = new UserDao();
	public User addUser(User user){
		return null;
	}

	public boolean deleteUser(User user){
		return false;
	}

	public boolean editUser(User user){
		return false;
	}

	public User getUser(User _user){
		return null;
	}

	public ArrayList<User> getUsers() throws ServiceException{
		try {
			return userDao.getUsers();
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}
	public boolean register(User user) {
		return  false;
	}

	public boolean autorization(User user) {
		return false;
	}
}