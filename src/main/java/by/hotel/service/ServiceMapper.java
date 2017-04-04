package by.hotel.service;

import by.hotel.service.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceMapper {
    final private static Map<String, CrudService> services = new HashMap();

    static {
        services.put("room", new RoomServiceImpl());
        services.put("EMPLOYEE", new EmployeeServiceImpl());
//        services.put("REPORT", new ReportServiceImpl());
        services.put("user", new UserServiceImpl());
        services.put("reservation", new ReservationServiceImpl());
    }

    public static CrudService getService(String serviceName) {
        return services.get(serviceName);
    }
}
