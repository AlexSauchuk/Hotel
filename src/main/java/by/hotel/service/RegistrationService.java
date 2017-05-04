package by.hotel.service;

import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;

/**
 * Created by 1 on 26.04.2017.
 */
public interface RegistrationService {
    User registration(User user)  throws ServiceException;
}
