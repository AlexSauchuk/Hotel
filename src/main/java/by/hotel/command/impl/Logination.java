package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.dao.UserDao;
import by.hotel.dao.impl.UserDaoImpl;

/**
 * Created by 1 on 28.02.2017.
 */
public class Logination implements Command {
    public boolean execute(String request) throws CommandException {
        UserDao userDao = new UserDaoImpl();
        String[] arrOfRequestData = request.split("&");
        String name = arrOfRequestData[1];
        String password = arrOfRequestData[2];

        User user = new User(name,password);
        if (userDao.autorization(user)){
            return true;
        }
        return false;
    }
}
