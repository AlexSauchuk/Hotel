package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.dao.UserDao;
import by.hotel.dao.daoimpl.UserDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements CrudService<User> {
	private UserDao userDao = new UserDaoImpl();
	public List<User> getAllEntities() throws ServiceException {
		try {
			return userDao.getUsers();
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public void addEntity(User entity) throws ServiceException {
		try {
			userDao.addUser(entity);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public void removeEntity(User entity) throws ServiceException {
		try {
			userDao.removeUser(entity);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public void updateEntity(User entity) throws ServiceException {
		try {
			userDao.updateUser(entity);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}
}