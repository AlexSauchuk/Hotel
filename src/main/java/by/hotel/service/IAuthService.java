package by.hotel.service;


/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:17
 */
public interface IAuthService {

	/**
	 * 
	 * @param login
	 * @param password
	 */
	boolean login(String login, String password);

	boolean logout();

}