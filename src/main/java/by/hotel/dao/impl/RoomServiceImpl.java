package by.hotel.dao.impl;


import by.hotel.bean.ReservationInfo;
import by.hotel.bean.Room;
import by.hotel.dao.RoomService;

import java.util.ArrayList;

/**
 * @author SK
 * @version 1.0
 * @created 16-���-2017 18:46:18
 */
public class RoomServiceImpl implements RoomService {

	public RoomServiceImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param id
	 */
	public boolean CancelReservationRoom(int id){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public Room FindRoomByPK(int id){
		return null;
	}

	public ArrayList<Room> GetRooms(){
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param _reservationInfo
	 */
	public boolean ReservationRoom(int id, ReservationInfo _reservationInfo){
		return false;
	}

}