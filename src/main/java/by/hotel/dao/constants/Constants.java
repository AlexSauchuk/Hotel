package by.hotel.dao.constants;

/**
 * Created by user1 on 28.03.2017.
 */
public class Constants {
    public static final String GET_ALL_NAMES_TABLES = "SHOW TABLES FROM `db_hotel`";
    public static final String GET_ALL_USERS = "SELECT `id`, `passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `login`, `password` FROM `db_hotel`.`user`";
    public static final String GET_ALL_ROOMS = "SELECT `room`.`id`, `rooms_count`, `beds_count`, `cost_per_day`, `additional_info`, `floor`, `phone` " +
                                               "FROM (`db_hotel`.`room` LEFT OUTER JOIN `db_hotel`.`room_type` ON `room`.`id_room_type` = `room_type`.`id`)";
    public static final String GET_ALL_RESERVATION_INFO = "SELECT `reservation`.`id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
                                               "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
}