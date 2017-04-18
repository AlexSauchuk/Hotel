package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface DiscountDao {
    List<Discount> getDiscounts(Connection connection) throws DAOException;

    void addDiscount(Discount discount, Connection connection) throws DAOException;

    void removeDiscount(Discount discount, Connection connection) throws DAOException;

    void updateDiscount(Discount discount, Connection connection) throws DAOException;

    Discount getDiscount(Integer id, Connection connection) throws DAOException;
}
