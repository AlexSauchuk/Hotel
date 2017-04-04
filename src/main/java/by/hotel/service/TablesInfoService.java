package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

public interface DatabaseService {
    List<String> getAllTablesNames() throws ServiceException;
}
