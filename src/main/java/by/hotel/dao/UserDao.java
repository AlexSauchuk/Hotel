package by.hotel.dao;

import by.hotel.bean.User;

public interface UserDao {
    public boolean register(User user);

    public boolean autorization(User user);
}
