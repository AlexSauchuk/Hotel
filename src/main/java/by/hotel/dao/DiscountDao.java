package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by 1 on 04.04.2017.
 */
public interface DiscountDao {
    List<Integer> getId() throws DAOException;
    List<Discount> getDiscounts() throws DAOException;

    void addDiscount(Discount discount) throws DAOException;

    void removeDiscount(Discount discount) throws DAOException;

    void updateDiscount(Discount discount) throws DAOException;

    Discount getDiscount(Integer id) throws DAOException;
}
