package by.hotel.service.impl;

import by.hotel.bean.Discount;
import by.hotel.builder.DiscountBuilder;
import by.hotel.dao.daoimpl.DiscountDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class DiscountServiceImpl extends AbstractService implements CrudServiceExtended<Discount> {
    private DiscountDaoImpl discountDao = new DiscountDaoImpl();

    public List<String> getAllHeaders() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return discountDao.getDiscountHeaders(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public List<Discount> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return discountDao.getDiscounts(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void addEntity(Discount entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            discountDao.addDiscount(entity,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void removeEntity(Discount discount) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            discountDao.removeDiscount(discount,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public void updateEntity(Discount entity) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            discountDao.updateDiscount(entity,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public Discount buildEntity(Map<String, String[]> params) throws ServiceException {
        return new DiscountBuilder().id(Integer.parseInt(params.get("id")[0]))
                .name(params.get("name")[0])
                .build();
    }
}