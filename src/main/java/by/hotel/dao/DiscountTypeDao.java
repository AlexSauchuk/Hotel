package by.hotel.dao;

import by.hotel.bean.DiscountType;
import by.hotel.dao.exception.DAOException;

import java.util.List;

/**
 * Created by 1 on 04.04.2017.
 */
public interface DiscountTypeDao {
    List<DiscountType> getDiscountTypes() throws DAOException;

    void addDiscountType(DiscountType discountType) throws DAOException;

    void removeDiscountType(DiscountType discountType) throws DAOException;

    void updateDiscountType(DiscountType discountType) throws DAOException;

    DiscountType getDiscountType(Integer id) throws DAOException;
}
