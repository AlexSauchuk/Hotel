package by.hotel.service;

import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;
import java.util.ArrayList;

public interface IUserService {

	User addUser(User user);

	boolean deleteUser(User user);

	boolean editUser(User user);

	User getUser(User user);

	ArrayList<User> getUsers() throws ServiceException;

	boolean register(User user);

	boolean autorization(User user);
}