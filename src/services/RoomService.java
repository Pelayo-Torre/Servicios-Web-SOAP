package services;

import java.sql.SQLException;
import java.util.List;

import exception.ClientException;
import exception.RoomException;
import model.Room;
import persistence.ManagerDAO;
import persistence.RoomDAO;
import validators.RoomValidator;

public class RoomService {

	private RoomDAO dao;
	private RoomValidator roomValidator = new RoomValidator();

	/**
	 * M�todo para a�adir una habitacion
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 * @throws RoomException
	 * @throws ClientException
	 */
	public String addRoom(Room room) throws SQLException, RoomException {
		roomValidator.validate(room);
		dao = ManagerDAO.getInstance().getRoomDAO();
		return dao.addRoom(room);
	}

	/**
	 * M�todo para borrar una habitaci�n
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws RoomException
	 */
	public String deleteRoom(Long id) throws SQLException, RoomException {
		dao = ManagerDAO.getInstance().getRoomDAO();

		Room r = dao.listRoom(id);
		if (r == null)
			throw new RoomException("La habitaci�n que se desea eliminar no existe", "404");

		return dao.deleteRoom(id);
	}

	/**
	 * M�todo para actualizar la habitaci�n que se pasa por par�metro
	 * 
	 * @param room
	 * @return
	 * @throws SQLException
	 * @throws ClientException
	 */
	public String updateRoom(Long id, Room room) throws SQLException, RoomException {
		roomValidator.validate(room);
		dao = ManagerDAO.getInstance().getRoomDAO();
		Room r = dao.listRoom(id);
		if (r == null)
			throw new RoomException("La habitaci�n que se desea eliminar no existe", "404");
		room.setId(id);
		return dao.updateRoom(room);
	}

	/**
	 * M�todo para obtener la habitaci�n cuyo id se pasa por par�metro
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Room listRoom(Long id) throws SQLException {
		dao = ManagerDAO.getInstance().getRoomDAO();
		return dao.listRoom(id);
	}

	/**
	 * M�todo para obtener la lista de habitaciones de un hotel
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Room> listRooms(Long hotelId) throws SQLException {
		dao = ManagerDAO.getInstance().getRoomDAO();
		return dao.listRoomsOfHotel(hotelId);
	}

}
