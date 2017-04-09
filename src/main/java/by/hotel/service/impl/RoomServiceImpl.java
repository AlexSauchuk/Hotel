package by.hotel.service.impl;

import by.hotel.bean.Room;
import by.hotel.dao.RoomDao;
import by.hotel.dao.daoimpl.RoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.CrudService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

public class RoomServiceImpl implements CrudService<Room> {
	private RoomDao roomDao = new RoomDaoImpl();

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

	public void removeEntity(Room entity) throws ServiceException {
		try {
			roomDao.removeRoom(entity);
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
}