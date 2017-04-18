package by.hotel.service.impl;

import by.hotel.bean.Discount;
import by.hotel.builder.DiscountBuilder;
import by.hotel.dao.daoimpl.DiscountDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class DiscountServiceImpl implements CrudServiceExtended<Discount> {
    private DiscountDaoImpl discountDao = new DiscountDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        try {
            return discountDao.getDiscountHeaders();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

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

    public void removeEntity(Discount discount) throws ServiceException {
        try {
            discountDao.removeDiscount(discount);
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

    public Discount buildEntity(Map<String, String[]> params) throws ServiceException {
        return new DiscountBuilder().id(Integer.parseInt(params.get("id")[0]))
                .name(params.get("name")[0])
                .build();
    }
}