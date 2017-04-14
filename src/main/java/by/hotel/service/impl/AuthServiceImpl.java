package by.hotel.service.impl;

import by.hotel.dao.AuthDao;
import by.hotel.dao.UserDao;
import by.hotel.dao.daoimpl.AuthDaoImpl;
import by.hotel.dao.daoimpl.UserDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AuthService;
import by.hotel.service.exception.ServiceException;

public class AuthServiceImpl implements AuthService {
	private AuthDao authDao = new AuthDaoImpl();
	public boolean authorisation(String login, String password)  throws ServiceException{

		try {
			return authDao.authorisation(login,password);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public boolean logout(){
		return false;
	}

}