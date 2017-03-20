package by.hotel.service;


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
	public User addUser(User _user);

	/**
	 * 
	 * @param _user
	 */
	public boolean deleteUser(User _user);

	/**
	 * 
	 * @param _user
	 */
	public boolean editUser(User _user);

	/**
	 * 
	 * @param _user
	 */
	public User getUser(User _user);

	public boolean register(User user);

	public boolean autorization(User user);

}