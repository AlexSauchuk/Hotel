package by.hotel.dao.constants;

public class Constants {
    public static final String GET_ALL_NAMES_TABLES = "SHOW TABLES FROM `db_hotel`";

    public static final String GET_ALL_USERS = "SELECT `user`.`id`, `passportNumber`, `name`, `surname`, `mobilePhone`, `login`, `password`, `role`, `email`,`role`.`id` AS `id_role`,`role`.`nameRole`,`role`.`update`,`role`.`delete`,`role`.`insert`,`role`.`create`,`role`.`select`,`role`.`drop`,`role`.`grant` " +
            "FROM (`db_hotel`.`user` LEFT OUTER JOIN `db_hotel`.`role` ON `user`.`role` = `role`.`id`)";
    public static final String ADD_USER = "INSERT INTO `db_hotel`.`user` (`passportNumber`, `name`, `surname`, `mobilePhone`, `password`, `login`,`role`,`email`) VALUES (?,?,?,?,?,?,?,?)";
    public static final String REMOVE_USER = "DELETE FROM `db_hotel`.`user` WHERE `id`=?";
    public static final String GET_USER = GET_ALL_USERS.concat(" WHERE `user`.`id`=?");
    public static final String UPDATE_USER = "UPDATE `db_hotel`.`user` SET `passportNumber`=?, `name`=?, `surname`=?, `mobilePhone`=?, `password`=?, `login`=?, `role`=?, `email`=? WHERE `id`=?";
    public static final String GET_ALL_USERS_HEADERS = "SELECT `id`, `surname`, `name` FROM `db_hotel`.`user`";

    public static final String GET_ALL_ROOMS = "SELECT `room`.`id`,`idRoomType`, `name`,`roomsCount`, `bedsCount`, `costPerDay`, `additionalInfo`,`bathroomsCount`,`size`, `floor`, `phone`, `path` " +
            "FROM (`db_hotel`.`room` LEFT OUTER JOIN `db_hotel`.`room_type` ON `room`.`idRoomType` = `room_type`.`id`)";
    public static final String ADD_ROOM = "INSERT INTO `db_hotel`.`room` (`idRoomType`, `name`,`floor`, `phone`, `path`) VALUES (?,?,?,?,?)";
    public static final String REMOVE_ROOM = "DELETE FROM `db_hotel`.`room` WHERE `id`=?";
    public static final String UPDATE_ROOM = "UPDATE `db_hotel`.`room` SET `idRoomType`=?, `name`=?,`floor`=?, `phone`=?, `path`=? WHERE `id`=?";
    public static final String GET_ROOM = GET_ALL_ROOMS.concat(" WHERE `room`.`id`=?");
    public static final String GET_ALL_ROOMS_HEADERS = "SELECT `id`, `name` FROM `db_hotel`.`room`";

    public static final String GET_ALL_ROOM_TYPES = "SELECT `id`, `roomsCount`, `bedsCount`, `costPerDay`, `additionalInfo`, `bathroomsCount`, `size` FROM `db_hotel`.`room_type`";
    public static final String ADD_ROOM_TYPE = "INSERT INTO `db_hotel`.`room_type` (`roomsCount`, `bedsCount`, `costPerDay`, `additionalInfo`, `bathroomsCount`, `size`) VALUES (?,?,?,?,?,?)";
    public static final String REMOVE_ROOM_TYPE = "DELETE FROM `db_hotel`.`room_type` WHERE `id`=?";
    public static final String UPDATE_ROOM_TYPE = "UPDATE `db_hotel`.`room_type` SET `roomsCount`=?, `bedsCount`=?, `costPerDay`=?, `additionalInfo`=?, `bathroomsCount`=?, `size`=? WHERE `id`=?";
    public static final String GET_ROOM_TYPE = GET_ALL_ROOM_TYPES.concat(" WHERE `roomType`.`id`=?");
    public static final String GET_ALL_ROOM_TYPES_HEADERS = "SELECT `id`, `roomsCount` FROM `db_hotel`.`room_type`";
    //  public static final String GET_ROOM_TYPE = "UPDATE `db_hotel`.`user` SET `passportNumber`='?', `name`='?', `surname`='?', `mobilePhone`='?', `password`='?' WHERE `id`='?'";

    public static final String GET_ALL_RESERVATIONS = "SELECT `reservation`.`id`, `idUser`,`user`.`name`, `surname`, `passportNumber` ,`mobilePhone`, `dateIn`, `dateOut`,`costAdditionalServices`, `idRoom`,`discount`.`name` AS `discountName`" +
            "FROM ((`db_hotel`.`reservation` " +
            "LEFT OUTER JOIN `db_hotel`.`user`" +
            "ON `reservation`.`idUser` = `user`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`discount`" +
            "ON `discount`.`id` = `idDiscount`)";
    public static final String ADD_RESERVATION = "INSERT INTO `db_hotel`.`reservation` (`idUser`, `dateIn`, `dateOut`, `costAdditionalServices`, `idRoom`) VALUES (?,?,?,?,?)";
    public static final String REMOVE_RESERVATION = "DELETE FROM `db_hotel`.`reservation` WHERE `id`=?";
    public static final String UPDATE_RESERVATION = "UPDATE `db_hotel`.`reservation` SET `idUser`=?, `dateIn`=?, `dateOut`=?, `costAdditionalServices`=?, `idDiscount`=? WHERE `id`=?";
    public static final String GET_RESERVATION = GET_ALL_RESERVATIONS.concat(" WHERE `reservation`.`id` = ?");
    //   public static final String GET_RESERVATION = "SELECT `id`, `idUser`, `name`, `surname`, `room_number`, `dateIn`, `dateOut`, `days_count` " +
    //          "FROM (`db_hotel`.`reservation` LEFT OUTER JOIN `db_hotel`.`user` ON `reservation`.`idUser` = `user`.`id`)";
    public static final String GET_ALL_RESERVATIONS_HEADERS = "SELECT `id`, `dateIn`, `dateOut` FROM `db_hotel`.`reservation`";


    public static final String GET_ALL_PARKING_SPACES = "SELECT `id`, `level`, `reserved` FROM `db_hotel`.`parking_space`";
    public static final String ADD_PARKING_SPACE = "INSERT INTO `db_hotel`.`parking_space` (`level`, `reserved`) VALUES (?,?)";
    public static final String REMOVE_PARKING_SPACE = "DELETE FROM `db_hotel`.`parking_space` WHERE `id`=?";
    public static final String UPDATE_PARKING_SPACE = "UPDATE `db_hotel`.`parking_space` SET `level`=?, `reserved`=? WHERE `id`=?";
    public static final String GET_PARKING_SPACE = GET_ALL_PARKING_SPACES.concat(" WHERE `id`=?");
    public static final String GET_ALL_PARKING_SPACES_HEADERS = "SELECT `id`, `level` FROM `db_hotel`.`parking_space`";

    public static final String GET_ALL_RESERVATION_PARKING_SPACES = "SELECT `idParkingSpace`,`idReservation`, `level`, `reserved`, `idUser`, `user`.`name`, `surname`, `passportNumber`,`mobilePhone`, `dateIn-in`, `dateOut`, `costAdditionalServices`, `idDiscount`,`discount`.`name` AS `discount_name`"  +
            "FROM ((((`db_hotel`.`reservation_parking_space`" +
            "LEFT OUTER JOIN `db_hotel`.`reservation`" +
            "ON `reservationParkingSpace`.`idReservation` = `reservation`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`user`" +
            "ON `reservation`.`idUser` = `user`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`parkingSpace`" +
            "ON `reservation_parking_space`.`idParkingSpace` = `parking_space`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`discount`" +
            "ON `idDiscount` = `discount`.`id`)";
    public static final String ADD_RESERVATION_PARKING_SPACE = "INSERT INTO `db_hotel`.`reservation_parking_space` (`idParkingSpace`, `idReservation`) VALUES (?,?)";
    public static final String REMOVE_RESERVATION_PARKING_SPACE = "DELETE FROM `db_hotel`.`reservation_parking_space` WHERE `idParkingSpace`=? AND `idReservation`=?";
    public static final String UPDATE_RESERVATION_PARKING_SPACE = "UPDATE `db_hotel`.`reservation_parking_space` SET `idParkingSpace`=?, `idReservation`=? WHERE `idParkingSpace`=? AND `idReservation`=?";
    public static final String GET_RESERVATION_PARKING_SPACE = GET_ALL_RESERVATION_PARKING_SPACES.concat(" WHERE `idParkingSpace` = ? AND `idReservation` = ?");

    public static final String GET_ALL_RESERVATION_ROOMS = "SELECT `idRoom`,`idRoomType`,`floor`, `phone`, `roomsCount`, `bedsCount`,`costPerDay`, `additionalInfo`,`idReservation`,`idUser`, `user`.`name`, `surname`, `passportNumber`,`mobilePhone`, `dateIn`, `dateOut`, `costAdditionalServices`, `idDiscount`,`discount`.`name` AS `discountName`" +
            "FROM (((((`db_hotel`.`reservation_room`" +
            "LEFT OUTER JOIN `db_hotel`.`reservation`" +
            "ON `reservation_room`.`idReservation` = `reservation`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`user`" +
            "ON `reservation`.`idUser` = `user`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`room`" +
            "ON `reservation_room`.`idRoom` = `room`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`room_type`" +
            "ON `idRoomType` = `room_type`.`id`)" +
            "LEFT OUTER JOIN `db_hotel`.`discount`" +
            "ON `idRoom` = `discount`.`id`)";
    public static final String ADD_RESERVATION_ROOM = "INSERT INTO `db_hotel`.`reservation_room` (`idRoom`, `idReservation`) VALUES (?,?)";
    public static final String REMOVE_RESERVATION_ROOM = "DELETE FROM `db_hotel`.`reservation_room` WHERE `idRoom`=? AND `idReservation`=?";
    public static final String UPDATE_RESERVATION_ROOM = "UPDATE `db_hotel`.`reservation_room` SET `idRoom`=?, `idReservation`=? WHERE `idRoom`=? AND `idReservation`=?";
    public static final String GET_RESERVATION_ROOM = GET_ALL_RESERVATION_ROOMS.concat(" WHERE `idRoom` = ? AND `idReservation` = ?");

    public static final String GET_ALL_DISCOUNTS = "SELECT `id`, `name` FROM `db_hotel`.`discount`";
    public static final String ADD_DISCOUNT = "INSERT INTO `db_hotel`.`discount` (`name`) VALUES (?)";
    public static final String REMOVE_DISCOUNT = "DELETE FROM `db_hotel`.`discount` WHERE `id`=?";
    public static final String UPDATE_DISCOUNT = "UPDATE `db_hotel`.`discount` SET `name`=? WHERE `id`=?";
    public static final String GET_ALL_DISCOUNTS_HEADERS = "SELECT `id`, `name` FROM `db_hotel`.`discount`";
    public static final String GET_DISCOUNT = GET_ALL_DISCOUNTS.concat(" WHERE `discount`.`id` = ?");

    public static final String GET_ALL_ROLES = "SELECT `id`,`nameRole`, `update`, `delete`, `insert`, `create`, `select`, `drop`, `grant` FROM `db_hotel`.`role`";
    public static final String ADD_ROLE = "INSERT INTO `db_hotel`.`role` (`nameRole`, `update`, `delete`, `insert`, `create`, `select`, `drop`, `grant`) VALUES (?,?,?,?,?,?,?,?)";
    public static final String REMOVE_ROLE = "DELETE FROM `db_hotel`.`role` WHERE `id`=?";
    public static final String UPDATE_ROLE = "UPDATE `db_hotel`.`role` SET `nameRole`=?, `update`=?, `delete`=?,`insert`=?, `create`=?, `select`=?,`drop`=?, `grant`=? WHERE `id`=?";
    public static final String GET_ROLE = GET_ALL_ROLES.concat(" WHERE `role`.`id` = ?");
    public static final String GET_ALL_ROLES_HEADERS = "SELECT `id`, `nameRole` FROM `db_hotel`.`role`";

    public static final String GET_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";
    public static final String AUTH_USER = GET_ALL_USERS.concat("WHERE `email`=? AND `password`=?");


    public static final String GET_LAST_INSERTED_DISCOUNT = "SELECT * FROM `db_hotel`.`discount` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_PARKING_SPACE = "SELECT * FROM `db_hotel`.`parking_space` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_RESERVATION = "SELECT * FROM `db_hotel`.`reservation` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_ROLE = "SELECT * FROM `db_hotel`.`role` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_ROOM = "SELECT * FROM `db_hotel`.`room` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_ROOM_TYPE = "SELECT * FROM `db_hotel`.`room_type` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_USER = "SELECT * FROM `db_hotel`.`user` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_RESERVATION_PARKING_SPACE = "SELECT * FROM `db_hotel`.`reservation_parking_space` WHERE `id`=LAST_INSERT_ID()";
    public static final String GET_LAST_INSERTED_RESERVATION_ROOM = "SELECT * FROM `db_hotel`.`reservation_room` WHERE `id`=LAST_INSERT_ID()";
}