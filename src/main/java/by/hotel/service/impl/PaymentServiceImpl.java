package by.hotel.service.impl;

import by.hotel.bean.Payment;
import by.hotel.bean.Room;
import by.hotel.dao.daoimpl.PaymentDaoImpl;
import by.hotel.dao.daoimpl.RoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by 1 on 07.04.2017.
 */
public class PaymentServiceImpl implements CrudService<Payment> {
    private PaymentDaoImpl paymentDao = new PaymentDaoImpl();

    public List<Payment> getAllEntities() throws ServiceException {
        try {
            return paymentDao.getPayments();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(Payment entity) throws ServiceException {
        try {
            paymentDao.addPayment(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(Payment entity) throws ServiceException {
        try {
            paymentDao.removePayment(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(Payment entity) throws ServiceException {
        try {
            paymentDao.updatePayment(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
