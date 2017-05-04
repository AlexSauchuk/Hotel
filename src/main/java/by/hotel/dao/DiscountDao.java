package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public interface DiscountDao {
    List<String> getDiscountHeaders(Connection connection) throws DAOException;
    List<Discount> getDiscounts(Connection connection) throws DAOException;
    void addDiscount(Discount discount, Connection connection) throws DAOException;
    void removeDiscount(Discount discount, Connection connection) throws DAOException;
    void updateDiscount(Discount discount, Connection connection) throws DAOException;
    Discount getLastInsertedDiscount(Connection connection) throws DAOException;
}
