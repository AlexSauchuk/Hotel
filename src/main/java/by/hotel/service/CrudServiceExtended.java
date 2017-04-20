package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

public interface CrudServiceExtended<T> extends CrudService<T> {
    List<String> getAllHeaders() throws ServiceException;
}
