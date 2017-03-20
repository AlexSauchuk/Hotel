package by.hotel.dao;

import by.hotel.bean.User;

public interface IReservationDao {

    boolean register(User user);
    boolean authorization(User user);
}
