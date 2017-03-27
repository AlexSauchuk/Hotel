package by.hotel.service.impl;


import by.hotel.bean.User;
import by.hotel.service.UserService;
import by.hotel.database.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:18
 */
public class UserServiceImpl implements UserService {

	public UserServiceImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param _user
	 */
	public User AddUser(User _user){
		return null;
	}

	/**
	 * 
	 * @param _user
	 */
	public boolean DeleteUser(User _user){
		return false;
	}

	/**
	 * 
	 * @param _user
	 */
	public boolean EditUser(User _user){
		return false;
	}

	/**
	 * 
	 * @param _user
	 */
	public User GetUser(User _user){
		return null;
	}

	public boolean register(User user) {

		return  false;
	}

	public boolean autorization(User user) {
		return false;
	}

}