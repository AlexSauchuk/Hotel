package by.hotel.dao;


import by.hotel.bean.User;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:18
 */
public interface UserService {

	/**
	 * 
	 * @param _user
	 */
	public User AddUser(User _user);

	/**
	 * 
	 * @param _user
	 */
	public boolean DeleteUser(User _user);

	/**
	 * 
	 * @param _user
	 */
	public boolean EditUser(User _user);

	/**
	 * 
	 * @param _user
	 */
	public User GetUser(User _user);

}