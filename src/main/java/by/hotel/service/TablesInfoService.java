package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

public interface TablesInfoService {
    List<String> getAllTablesNames() throws ServiceException;
}
