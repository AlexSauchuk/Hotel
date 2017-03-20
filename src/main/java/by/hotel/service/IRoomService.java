package by.hotel.service;


import by.hotel.bean.ReservationInfo;
import by.hotel.bean.Room;

import java.util.ArrayList;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:18
 */
public interface IRoomService {

	/**
	 * 
	 * @param id
	 */
	boolean cancelReservationRoom(int id);

	/**
	 * 
	 * @param id
	 */
	Room findRoomByPK(int id);

	ArrayList<Room> getRooms();

	/**
	 * 
	 * @param id
	 * @param reservationInfo
	 */
	boolean reservationRoom(int id, ReservationInfo reservationInfo);

}