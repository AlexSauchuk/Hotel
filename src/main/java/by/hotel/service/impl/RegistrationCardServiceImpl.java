package by.hotel.service.impl;

import by.hotel.bean.RegistrationCard;
import by.hotel.dao.daoimpl.RegistrationCardDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

public class RegistrationCardServiceImpl implements CrudService<RegistrationCard> {
    private RegistrationCardDaoImpl registrationCardDao = new RegistrationCardDaoImpl();

    public List<RegistrationCard> getAllEntities() throws ServiceException {
        try {
            return registrationCardDao.getRegistrationCards();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void addEntity(RegistrationCard entity) throws ServiceException {
        try {
            registrationCardDao.addRegistrationCard(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void removeEntity(RegistrationCard entity) throws ServiceException {
        try {
            registrationCardDao.removeRegistrationCard(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public void updateEntity(RegistrationCard entity) throws ServiceException {
        try {
            registrationCardDao.updateRegistrationCard(entity);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
