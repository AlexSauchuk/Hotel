package by.hotel.dao;

import by.hotel.bean.User;

public interface IGuestDao {

    boolean register(User user);
    boolean authorization(User user);
}
