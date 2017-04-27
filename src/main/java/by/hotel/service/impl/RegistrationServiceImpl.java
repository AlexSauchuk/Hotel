package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.service.AuthService;
import by.hotel.service.CrudService;
import by.hotel.service.RegistrationService;
import by.hotel.service.exception.ServiceException;

/**
 * Created by 1 on 26.04.2017.
 */
public class RegistrationServiceImpl implements RegistrationService{
    AuthService authService = new AuthServiceImpl();
    CrudService crudService = new UserServiceImpl();
    @Override
    public User registration(User user) throws ServiceException {
        if(authService.checkUser(user.getLogin(),user.getPassword()) != null){
            crudService.addEntity(user);
        }
        return null;
    }
}
