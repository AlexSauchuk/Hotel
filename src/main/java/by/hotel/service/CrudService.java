package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

public interface CrudService<T> {
    List<Integer> getAllId() throws ServiceException;
    List<T> getAllEntities() throws ServiceException;
    void addEntity(T entity) throws ServiceException;
    void removeEntity(T entity) throws ServiceException;
    void updateEntity(T entity) throws ServiceException;
   // <T> getEntity(Integer id) throws ServiceException;
}
