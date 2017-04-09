package by.hotel.dao.constants;

/**
 * Created by user1 on 28.03.2017.
 */
public class Constants {
    public static final String GET_ALL_NAMES_TABLES = "SHOW TABLES FROM `db_hotel`";


    public static final String GET_ALL_USERS = "SELECT `id`, `passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `login`, `password` FROM `db_hotel`.`user`";
    public static final String ADD_USER = "INSERT INTO `db_hotel`.`user` (`passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `password`) VALUES ('?', '?', '?', '?', '?', '?')";
    public static final String REMOVE_USER = "DELETE FROM `db_hotel`.`user` WHERE `id`='?'";
    public static final String UPDATE_USER = "UPDATE `db_hotel`.`user` SET `passport_number`='?', `name`='?', `surname`='?', `sex`='?', `mobile_phone`='?', `password`='?' WHERE `id`='?'";
    public static final String GET_USER = "SELECT `id`, `passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `login`, `password` FROM `db_hotel`.`user` WHERE `id`='?'";


    public static final String GET_ALL_ROOMS = "SELECT `room`.`id`,`room_type`.`id`, `rooms_count`, `beds_count`, `cost_per_day`, `additional_info`, `floor`, `phone` " +
            "FROM (`db_hotel`.`room` LEFT OUTER JOIN `db_hotel`.`room_type` ON `room`.`id_room_type` = `room_type`.`id`)";
    public static final String ADD_ROOM = "INSERT INTO `db_hotel`.`room` (`id_room_type`, `floor`, `phone`) VALUES ('?', '?', '?')";
    public static final String REMOVE_ROOM = "DELETE FROM `db_hotel`.`room` WHERE `id`='?'";
    public static final String UPDATE_ROOM = "UPDATE `db_hotel`.`room` SET `id_room_type`='?', `floor`='?', `phone`='?'";
  //  public static final String GET_ROOM = "UPDATE `db_hotel`.`user` SET `passport_number`='?', `name`='?', `surname`='?', `sex`='?', `mobile_phone`='?', `password`='?' WHERE `id`='?'";

    public static final String GET_ALL_ROOM_TYPES = "SELECT `id`, `rooms_count`, `beds_count`, `cost_per_day`, `additional_info` FROM `db_hotel`.`room_type`";
    public static final String ADD_ROOM_TYPE = "INSERT INTO `db_hotel`.`room_type` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_ROOM_TYPE = "DELETE FROM `db_hotel`.`room_type` WHERE `id`='?'";
    public static final String UPDATE_ROOM_TYPE = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
  //  public static final String GET_ROOM_TYPE = "UPDATE `db_hotel`.`user` SET `passport_number`='?', `name`='?', `surname`='?', `sex`='?', `mobile_phone`='?', `password`='?' WHERE `id`='?'";

    public static final String GET_ALL_RESERVATIONS = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_RESERVATION = "INSERT INTO `db_hotel`.`UPDATE_RESERVATION` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_RESERVATION = "DELETE FROM `db_hotel`.`UPDATE_RESERVATION` WHERE `id`='?'";
    public static final String UPDATE_RESERVATION = "UPDATE `db_hotel`.`UPDATE_RESERVATION` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
 //   public static final String GET_RESERVATION = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
  //          "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";




    //Исправить запросы ниже
    public static final String GET_ALL_DISCOUNT_TYPES = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_DISCOUNT_TYPE = "INSERT INTO `db_hotel`.`room_type` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_DISCOUNT_TYPE = "DELETE FROM `db_hotel`.`room_type` WHERE `id`='?'";
    public static final String UPDATE_DISCOUNT_TYPE = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
    public static final String GET_DISCOUNT_TYPE = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";

    public static final String GET_ALL_DISCOUNTS = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_DISCOUNT = "INSERT INTO `db_hotel`.`discount` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_DISCOUNT = "DELETE FROM `db_hotel`.`discount` WHERE `id`='?'";
    public static final String UPDATE_DISCOUNT = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
 //   public static final String GET_DISCOUNT = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
  //          "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";


    public static final String GET_ALL_PAYMENTS = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_PAYMENT = "INSERT INTO `db_hotel`.`discount` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_PAYMENT = "DELETE FROM `db_hotel`.`discount` WHERE `id`='?'";
    public static final String UPDATE_PAYMENT = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
    public static final String GET_PAYMENT = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";


    public static final String GET_ALL_PARKING_SPACES = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_PARKING_SPACE = "INSERT INTO `db_hotel`.`discount` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_PARKING_SPACE = "DELETE FROM `db_hotel`.`discount` WHERE `id`='?'";
    public static final String UPDATE_PARKING_SPACE = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
    public static final String GET_PARKING_SPACE = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";

    public static final String GET_ALL_REGISTRATION_CARDS = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_REGISTRATION_CARD = "INSERT INTO `db_hotel`.`discount` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_REGISTRATION_CARD = "DELETE FROM `db_hotel`.`discount` WHERE `id`='?'";
    public static final String UPDATE_REGISTRATION_CARD = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
    public static final String GET_REGISTRATION_CARD = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";


    public static final String GET_ALL_RESERVATION_PARKING_SPACES = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_RESERVATION_PARKING_SPACE = "INSERT INTO `db_hotel`.`discount` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_RESERVATION_PARKING_SPACE = "DELETE FROM `db_hotel`.`discount` WHERE `id`='?'";
    public static final String UPDATE_RESERVATION_PARKING_SPACE = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
    public static final String GET_RESERVATION_PARKING_SPACE = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";


    public static final String GET_ALL_RESERVATION_ROOMS = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String ADD_RESERVATION_ROOM = "INSERT INTO `db_hotel`.`discount` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`) VALUES ('?', '?', '?', '?')";
    public static final String REMOVE_RESERVATION_ROOM = "DELETE FROM `db_hotel`.`discount` WHERE `id`='?'";
    public static final String UPDATE_RESERVATION_ROOM = "UPDATE `db_hotel`.`room_type` SET `rooms_count`='?', `beds_count`='?', `cost_per_day`='?', `additional_info`='?' WHERE `id`='?'";
    public static final String GET_RESERVATION_ROOM = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
            "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
}
