package by.hotel.service;


import by.hotel.bean.ReservationInfo;
import by.hotel.bean.Room;

import java.util.ArrayList;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:18
 */
public interface RoomService {

	/**
	 * 
	 * @param id
	 */
	public boolean CancelReservationRoom(int id);

	/**
	 * 
	 * @param id
	 */
	public Room FindRoomByPK(int id);

	public ArrayList<Room> GetRooms();

	/**
	 * 
	 * @param id
	 * @param _reservationInfo
	 */
	public boolean ReservationRoom(int id, ReservationInfo _reservationInfo);

}