package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.UserDao;
import by.hotel.dao.daoimpl.UserDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public void removeEntity(User user) throws ServiceException {
		try {
			userDao.removeUser(user);
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

	public User buildEntity(Map<String,String[]> params) throws ServiceException {
		return new UserBuilder().id(Integer.parseInt(params.get("id")[0]))
				.name(params.get("name")[0])
				.surname(params.get("surname")[0])
				.passportNumber(params.get("passport_number")[0])
				.login(params.get("login")[0])
				.password(params.get("password")[0])
				.passportNumber(params.get("passport_number")[0])
				.sex(params.get("sex")[0])
				.idRole(params.get("idRole")[0].equals("null") ? 0 : Integer.parseInt(params.get("idRole")[0]))
				.build();
	}
}