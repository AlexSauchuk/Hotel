package by.hotel.service.impl;

import by.hotel.bean.Discount;
import by.hotel.bean.DiscountType;
import by.hotel.dao.daoimpl.DiscountDaoImpl;
import by.hotel.dao.daoimpl.DiscountTypeDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by 1 on 07.04.2017.
 */
public class DiscountTypeServiceImpl implements CrudService<DiscountType> {
    private DiscountTypeDaoImpl discountTypeDao = new DiscountTypeDaoImpl();

    public List<DiscountType> getAllEntities() throws ServiceException {
        try {
            return discountTypeDao.getDiscountTypes();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(DiscountType entity) throws ServiceException {
        try {
            discountTypeDao.addDiscountType(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(DiscountType entity) throws ServiceException {
        try {
            discountTypeDao.removeDiscountType(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(DiscountType entity) throws ServiceException {
        try {
            discountTypeDao.updateDiscountType(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
