package by.hotel.service;


public interface AuthService {

	boolean login(String login, String password);
	boolean logout();
}