package by.hotel.service;

import by.hotel.service.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceMapper {
    final private static Map<String, CrudService> services = new HashMap();

    static {
        services.put("DISCOUNT", new DiscountServiceImpl());
        services.put("DISCOUNT_TYPE", new DiscountTypeServiceImpl());
        services.put("PARKING_SPACE", new ParkingSpaceServiceImpl());
        services.put("PAYMENT", new PaymentServiceImpl());
        services.put("REGISTRATION_CARD", new RegistrationCardServiceImpl());
        services.put("RESERVATION", new ReservationServiceImpl());
        services.put("RESERVATION_PARKING_SPACE", new ReservationParkingSpaceServiceImpl());

        services.put("RESERVATION_M2M_ROOM", new ReservationRoomServiceImpl());
        services.put("ROOM", new RoomServiceImpl());
        services.put("ROOM_TYPE", new RoomTypeServiceImpl());
        services.put("USER", new UserServiceImpl());
        //services.put("REPORT", new ReportServiceImpl());

    }

    public static CrudService getService(String serviceName) {
        return services.get(serviceName.toUpperCase());
    }

}
