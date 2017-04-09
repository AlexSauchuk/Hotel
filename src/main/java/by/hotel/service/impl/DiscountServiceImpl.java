package by.hotel.service.impl;

import by.hotel.bean.Discount;
import by.hotel.bean.Room;
import by.hotel.dao.daoimpl.DiscountDaoImpl;
import by.hotel.dao.daoimpl.RoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

public class DiscountServiceImpl implements CrudService<Discount> {
    private DiscountDaoImpl discountDao = new DiscountDaoImpl();

    public List<Discount> getAllEntities() throws ServiceException {
        try {
            return discountDao.getDiscounts();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(Discount entity) throws ServiceException {
        try {
            discountDao.addDiscount(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(Discount entity) throws ServiceException {
        try {
            discountDao.removeDiscount(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(Discount entity) throws ServiceException {
        try {
            discountDao.updateDiscount(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}