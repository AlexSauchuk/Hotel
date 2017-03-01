package by.hotel.dao.impl;

import by.hotel.bd.DB;
import by.hotel.bean.User;
import by.hotel.dao.UserService;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {

	public User addUser(User user){
		return null;
	}

	public boolean deleteUser(User user){
		return false;
	}

	public boolean editUser(User user){
		return false;
	}

	public User getUser(User user){
		return null;
	}

	public ArrayList<User> getAllUsers() throws DAOException {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		DB dataBase=null;
		ArrayList<User> users=new ArrayList<User>();

		try {
			dataBase=new DB();
			connection=dataBase.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT passport_number,name,surname,sex,mobile_phone,password FROM guest");
			while(resultSet.next()){
				User user=new User();
				user.setPassportNumber(resultSet.getString("passport_number"));
				user.setName(resultSet.getString("name"));
				user.setSurname(resultSet.getString("surname"));
				user.setSex(resultSet.getString("sex"));
				user.setMobilePhone(resultSet.getString("mobile_phone"));
				user.setPassword(resultSet.getString("password"));
				users.add(user);
			}
			return users;
		}catch (SQLException e){
			throw new DAOException(e);
		}finally {
			try{
				if(resultSet!=null){
					resultSet.close();
				}
				if(statement!=null){
					statement.close();
				}
				dataBase.closeConnection();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}