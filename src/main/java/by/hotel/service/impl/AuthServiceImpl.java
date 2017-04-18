package by.hotel.service.impl;

import by.hotel.dao.AuthDao;
import by.hotel.dao.UserDao;
import by.hotel.dao.daoimpl.AuthDaoImpl;
import by.hotel.dao.daoimpl.UserDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;

public class AuthServiceImpl extends AbstractService implements AuthService {
	private AuthDao authDao = new AuthDaoImpl();
	public boolean authorisation(String login, String password)  throws ServiceException{
		Connection connection = null;
		try {
			connection = getConnection();
			return authDao.authorisation(login,password,getConnection());
		}catch (DAOException e){
			throw new ServiceException(e);
		}finally {
			closeConnection(connection);
		}
	}

	public boolean logout(){
		return false;
	}

}