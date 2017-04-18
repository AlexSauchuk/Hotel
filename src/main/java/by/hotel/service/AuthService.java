package by.hotel.service;


import by.hotel.service.exception.ServiceException;

public interface AuthService {

	boolean authorisation(String login, String password)  throws ServiceException;
}