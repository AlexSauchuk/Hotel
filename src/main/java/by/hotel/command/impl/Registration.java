package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.Command;
import by.hotel.command.exception.CommandException;
import by.hotel.dao.IReservationDao;
import by.hotel.dao.daoimpl.ReservationDao;

/**
 * Created by 1 on 28.02.2017.
 */
public class Registration implements Command {
    public boolean execute(String request) throws CommandException {
        IReservationDao IUserDao = new ReservationDao();
        String[] arrOfRequestData = request.split("&");
        String name = arrOfRequestData[1];
        String password = arrOfRequestData[2];

        return false;

    }
}
