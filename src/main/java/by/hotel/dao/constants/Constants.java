package by.hotel.dao.constants;

public class Constants {
    public static final String GET_ALL_NAMES_TABLES = "SHOW TABLES FROM `db_hotel`";

    public static final String GET_ALL_USERS = "SELECT `user`.`id`, `passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `login`, `password`, `role`,`role`.`id` AS `id_role`,`role`.`name_role`,`role`.`update`,`role`.`delete`,`role`.`insert`,`role`.`create`,`role`.`select`,`role`.`drop`,`role`.`grant` " +
            "FROM (`db_hotel`.`user` LEFT OUTER JOIN `db_hotel`.`role` ON `user`.`role` = `role`.`id`)";
    public static final String ADD_USER = "INSERT INTO `db_hotel`.`user` (`passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `password`, `login`,`role`) VALUES (?,?,?,?,?,?,?,?)";
    public static final String REMOVE_USER = "DELETE FROM `db_hotel`.`user` WHERE `id`=?";
    public static final String UPDATE_USER = "UPDATE `db_hotel`.`user` SET `passport_number`=?, `name`=?, `surname`=?, `sex`=?, `mobile_phone`=?, `password`=?, `login`=?, `role`=? WHERE `id`=?";
    public static final String GET_USER = "SELECT `id`, `passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `password`, `login`, `role` FROM `db_hotel`.`user` WHERE `id`=?";
    public static final String GET_ALL_USERS_HEADERS = "SELECT `id`, `surname`, `name` FROM `db_hotel`.`user`";

    public static final String GET_ALL_ROOMS = "SELECT `room`.`id`,`id_room_type`, `name`,`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`,`bathrooms_count`,`size`, `floor`, `phone` " +
            "FROM (`db_hotel`.`room` LEFT OUTER JOIN `db_hotel`.`room_type` ON `room`.`id_room_type` = `room_type`.`id`)";
    public static final String ADD_ROOM = "INSERT INTO `db_hotel`.`room` (`id_room_type`, `name`,`floor`, `phone`) VALUES (?,?,?,?)";
    public static final String REMOVE_ROOM = "DELETE FROM `db_hotel`.`room` WHERE `id`=?";
    public static final String UPDATE_ROOM = "UPDATE `db_hotel`.`room` SET `id_room_type`=?, `name`=?,`floor`=?, `phone`=? WHERE `id`=?";
    public static final String GET_ALL_ROOMS_HEADERS = "SELECT `id`, `name` FROM `db_hotel`.`room`";
    //  public static final String GET_ROOM = "UPDATE `db_hotel`.`user` SET `passport_number`='?', `name`='?', `surname`='?', `sex`='?', `mobile_phone`='?', `password`='?' WHERE `id`='?'";

    public static final String GET_ALL_ROOM_TYPES = "SELECT `id`, `rooms_count`, `beds_count`, `cost_per_day`, `additional_info`, `bathrooms_count`, `size` FROM `db_hotel`.`room_type`";
    public static final String ADD_ROOM_TYPE = "INSERT INTO `db_hotel`.`room_type` (`rooms_count`, `beds_count`, `cost_per_day`, `additional_info`, `bathrooms_count`, `size`) VALUES (?,?,?,?,?,?)";
    public static final String REMOVE_ROOM_TYPE = "DELETE FROM `db_hotel`.`room_type` WHERE `id`=?";
    public static final String UPDATE_ROOM_TYPE = "UPDATE `db_hotel`.`room_type` SET `rooms_count`=?, `beds_count`=?, `cost_per_day`=?, `additional_info`=?, `bathrooms_count`=?, `size`=? WHERE `id`=?";
    public static final String GET_ALL_ROOM_TYPES_HEADERS = "SELECT `id`, `rooms_count` FROM `db_hotel`.`room_type`";
    //  public static final String GET_ROOM_TYPE = "UPDATE `db_hotel`.`user` SET `passport_number`='?', `name`='?', `surname`='?', `sex`='?', `mobile_phone`='?', `password`='?' WHERE `id`='?'";

    public static final String GET_ALL_RESERVATIONS = "SELECT `reservation`.`id`, `id_user`,`user`.`name`, `surname`, `passport_number`, `sex` ,`mobile_phone`, `date-in`, `date-out`,`cost_additional_services`, `discount_id`,`discount`.`name` AS `discount_name`" +
            "FROM ((`db_hotel`.`reservation` " +
            "LEFT OUTER JOIN `db_hotel`.`user`" +
            "ON `reservation`.`id_user` = `user`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`discount`" +
            "ON `discount`.`id` = `discount_id`)";
    public static final String ADD_RESERVATION = "INSERT INTO `db_hotel`.`reservation` (`id_user`, `date-in`, `date-out`, `cost_additional_services`, `discount_id`) VALUES (?,?,?,?,?)";
    public static final String REMOVE_RESERVATION = "DELETE FROM `db_hotel`.`reservation` WHERE `id`=?";
    public static final String UPDATE_RESERVATION = "UPDATE `db_hotel`.`reservation` SET `id_user`=?, `date-in`=?, `date-out`=?, `cost_additional_services`=?, `discount_id`=? WHERE `id`=?";
    //   public static final String GET_RESERVATION = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
    //          "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";
    public static final String GET_ALL_RESERVATIONS_HEADERS = "SELECT `id`, `date-in`, `date-out` FROM `db_hotel`.`reservation`";


    public static final String GET_ALL_PARKING_SPACES = "SELECT `id`, `level`, `is_reserved` FROM `db_hotel`.`parking_space`";
    public static final String ADD_PARKING_SPACE = "INSERT INTO `db_hotel`.`parking_space` (`level`, `is_reserved`) VALUES (?,?)";
    public static final String REMOVE_PARKING_SPACE = "DELETE FROM `db_hotel`.`parking_space` WHERE `id`=?";
    public static final String UPDATE_PARKING_SPACE = "UPDATE `db_hotel`.`parking_space` SET `level`=?, `is_reserved`=? WHERE `id`=?";
    public static final String GET_PARKING_SPACE = "SELECT `id`, `level`, `is_reserved` FROM `db_hotel`.`parking_space` WHERE `id`=?";
    public static final String GET_ALL_PARKING_SPACES_HEADERS = "SELECT `id`, `level` FROM `db_hotel`.`parking_space`";

    public static final String GET_ALL_RESERVATION_PARKING_SPACES = "SELECT `id_parking_space`,`id_reservation`, `level`, `is_reserved`, `id_user`, `user`.`name`, `surname`, `passport_number`, `sex` ,`mobile_phone`, `date-in`, `date-out`, `cost_additional_services`, `discount_id`,`discount`.`name` AS `discount_name`"  +
            "FROM ((((`db_hotel`.`reservation_parking_space`" +
            "LEFT OUTER JOIN `db_hotel`.`reservation`" +
            "ON `reservation_parking_space`.`id_reservation` = `reservation`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`user`" +
            "ON `reservation`.`id_user` = `user`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`parking_space`" +
            "ON `reservation_parking_space`.`id_parking_space` = `parking_space`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`discount`" +
            "ON `discount_id` = `discount`.`id`)";
    public static final String ADD_RESERVATION_PARKING_SPACE = "INSERT INTO `db_hotel`.`reservation_parking_space` (`id_parking_space`, `id_reservation`) VALUES (?,?)";
    public static final String REMOVE_RESERVATION_PARKING_SPACE = "DELETE FROM `db_hotel`.`reservation_parking_space` WHERE `id_parking_space`=? AND `id_reservation`=?";
    public static final String UPDATE_RESERVATION_PARKING_SPACE = "UPDATE `db_hotel`.`reservation_parking_space` SET `id_parking_space`=?, `id_reservation`=? WHERE `id_parking_space`=? AND `id_reservation`=?";
    public static final String GET_RESERVATION_PARKING_SPACE = "";

    public static final String GET_ALL_RESERVATION_ROOMS = "SELECT `id_room`,`id_room_type`,`floor`, `phone`, `rooms_count`, `beds_count`,`cost_per_day`, `additional_info`,`id_reservation`,`id_user`, `user`.`name`, `surname`, `passport_number`,`sex` ,`mobile_phone`, `date-in`, `date-out`, `cost_additional_services`, `discount_id`,`discount`.`name` AS `discount_name`" +
            "FROM (((((`db_hotel`.`reservation_room`" +
            "LEFT OUTER JOIN `db_hotel`.`reservation`" +
            "ON `reservation_room`.`id_reservation` = `reservation`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`user`" +
            "ON `reservation`.`id_user` = `user`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`room`" +
            "ON `reservation_room`.`id_room` = `room`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`room_type`" +
            "ON `id_room_type` = `room_type`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`discount`" +
            "ON `discount_id` = `discount`.`id`)";
    public static final String ADD_RESERVATION_ROOM = "INSERT INTO `db_hotel`.`reservation_room` (`id_room`, `id_reservation`) VALUES (?,?)";
    public static final String REMOVE_RESERVATION_ROOM = "DELETE FROM `db_hotel`.`reservation_room` WHERE `id_room`=? AND `id_reservation`=?";
    public static final String UPDATE_RESERVATION_ROOM = "UPDATE `db_hotel`.`reservation_room` SET `id_room`=?, `id_reservation`=? WHERE `id_room`=? AND `id_reservation`=?";
    public static final String GET_RESERVATION_ROOM = "";

    public static final String GET_ALL_DISCOUNTS = "SELECT `id`, `name` FROM `db_hotel`.`discount`";
    public static final String ADD_DISCOUNT = "INSERT INTO `db_hotel`.`discount` (`name`) VALUES (?)";
    public static final String REMOVE_DISCOUNT = "DELETE FROM `db_hotel`.`discount` WHERE `id`=?";
    public static final String UPDATE_DISCOUNT = "UPDATE `db_hotel`.`discount` SET `name`=? WHERE `id`=?";
    public static final String GET_ALL_DISCOUNTS_HEADERS = "SELECT `id`, `name` FROM `db_hotel`.`discount`";
    //   public static final String GET_DISCOUNT = "SELECT `id`, `id_user`, `name`, `surname`, `room_number`, `date-in`, `date-out`, `days_count` " +
    //          "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`id_user` = `user`.`id`)";

    public static final String GET_ALL_ROLES = "SELECT `id`,`name_role`, `update`, `delete`, `insert`, `create`, `select`, `drop`, `grant` FROM `db_hotel`.`role`";
    public static final String ADD_ROLE = "INSERT INTO `db_hotel`.`role` (`name_role`, `update`, `delete`, `insert`, `create`, `select`, `drop`, `grant`) VALUES (?,?,?,?,?,?,?,?)";
    public static final String REMOVE_ROLE = "DELETE FROM `db_hotel`.`role` WHERE `id`=?";
    public static final String UPDATE_ROLE = "UPDATE `db_hotel`.`role` SET `name_role`=?, `update`=?, `delete`=?,`insert`=?, `create`=?, `select`=?,`drop`=?, `grant`=? WHERE `id`=?";
    public static final String GET_ALL_ROLES_HEADERS = "SELECT `id`, `name_role` FROM `db_hotel`.`role`";

    public static final String GET_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";
    public static final String AUTR_USER = "SELECT `passport_number`, `name`, `surname`, `sex`, `mobile_phone`, `login`, `role` FROM `db_hotel`.`user` WHERE `id`=? AND `password`=?";
}