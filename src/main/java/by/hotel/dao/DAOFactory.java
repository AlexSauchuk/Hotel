package by.hotel.dao;

import by.hotel.dao.impl.AuthServiceImpl;
import by.hotel.dao.impl.EmployeeServiceImpl;
import by.hotel.service.AuthService;
import by.hotel.service.EmployeesService;

/**
 * Created by SK on 16.02.2017.
 */
public class DAOFactory {

    public AuthService getAuthService(){
        return new AuthServiceImpl();
    }

    public EmployeesService getEmployeesService(){
        return new EmployeeServiceImpl();
    }


}
