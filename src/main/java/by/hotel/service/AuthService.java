package by.hotel.service;


import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;

public interface AuthService {

	User checkUser(String login, String password)  throws ServiceException;
}