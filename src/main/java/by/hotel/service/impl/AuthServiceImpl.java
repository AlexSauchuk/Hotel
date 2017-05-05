package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.dao.AuthDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.UserDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;

public class AuthServiceImpl extends AbstractService implements AuthService {
	private AuthDao authDao = new UserDaoImpl();
	public User checkUser(String login, String password)  throws ServiceException{
		Connection connection = null;
		User user = null;
		try {
			connection = getConnection();
			user = authDao.authorisation(login,password,connection);
		}catch (DAOException e){
			throw new ServiceException(e);
		}finally {
			closeConnection(connection);
		}
		return user;
	}

	public boolean logout(){
		return false;
	}

}