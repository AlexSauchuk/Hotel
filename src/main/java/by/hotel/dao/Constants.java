package by.hotel.dao;

/**
 * Created by user1 on 28.03.2017.
 */
public class Constants {
    public static final String GET_ALL_USERS = "SELECT id, passport_number, name, surname, sex, mobile_phone, login,password FROM db_hotel.user";
    public static final String GET_ALL_ROOMS = "SELECT room.id, rooms_count, beds_count, cost_per_day, additional_info, floor, phone " +
                                               "FROM (db_hotel.room LEFT OUTER JOIN db_hotel.room_type ON room.id_room_type = room_type.id)";
}
