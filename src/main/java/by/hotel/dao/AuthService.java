package by.hotel.dao;


/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:17
 */
public interface AuthService {

	/**
	 * 
	 * @param login
	 * @param password
	 */
	public boolean Login(String login, String password);

	public boolean Logout();

}