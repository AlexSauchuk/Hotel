package by.hotel.service.impl;

import by.hotel.bean.Room;
import by.hotel.builder.RoomBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.RoomDao;
import by.hotel.dao.daoimpl.RoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class RoomServiceImpl implements CrudServiceExtended<Room> {
	private RoomDao roomDao = new RoomDaoImpl();

	public List<String> getAllHeaders() throws ServiceException {
		try {
			return roomDao.getRoomHeaders();
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public List<Room> getAllEntities() throws ServiceException {
		try {
			return roomDao.getRooms();
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public void addEntity(Room entity) throws ServiceException {
		try {
			roomDao.addRoom(entity);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public void removeEntity(Room room) throws ServiceException {
		try {
			roomDao.removeRoom(room);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

	public void updateEntity(Room entity) throws ServiceException {
		try {
			roomDao.updateRoom(entity);
		}catch (DAOException e){
			throw new ServiceException(e);
		}
	}

    public Room buildEntity(Map<String, String[]> params) throws ServiceException {
		return new RoomBuilder().id(Integer.parseInt(params.get("id")[0]))
				.roomType(new RoomTypeBuilder().id(Integer.parseInt(params.get("id_roomType")[0]))
						.build())
				.floor(Integer.parseInt(params.get("floor")[0]))
				.phone(params.get("phone")[0])
				.build();
	}
}