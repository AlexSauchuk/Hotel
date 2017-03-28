package by.hotel.service;

import by.hotel.service.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 27.03.2017.
 */
public class ServiceMapper {
    final private static Map<String, CrudService> services = new HashMap();

    static {
        services.put("ROOM", new RoomServiceImpl());
        services.put("EMPLOYEE", new EmployeeServiceImpl());
//        services.put("REPORT", new ReportServiceImpl());
        services.put("USER", new UserServiceImpl());
        services.put("RESERVATION_INFO", new ReservationServiceImpl());
    }

    public static CrudService getService(String serviceName) {
        return services.get(serviceName);
    }

}
