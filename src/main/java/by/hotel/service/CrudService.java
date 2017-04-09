package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Created by user1 on 27.03.2017.
 */
public interface CrudService<T> {
    List<T> getAllEntities() throws ServiceException;
    void addEntity(T entity) throws ServiceException;
    void removeEntity(T entity) throws ServiceException;
    void updateEntity(T entity) throws ServiceException;
   // <T> getEntity(Integer id) throws ServiceException;
}
