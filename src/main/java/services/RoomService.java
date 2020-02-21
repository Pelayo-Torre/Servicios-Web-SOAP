package services;

import java.util.List;

import exception.RoomException;
import model.Room;
import persistence.ManagerDAO;
import persistence.RoomDAO;
import validators.RoomValidator;

public class RoomService {

	private RoomDAO dao = ManagerDAO.getInstance().getRoomDAO();
	private RoomValidator roomValidator = new RoomValidator();

	/**
	 * M�todo para a�adir una habitacion
	 * 
	 * @param room
	 * @return
	 * @throws RoomException
	 */
	public String addRoom(Room room) throws RoomException {
		roomValidator.validate(room);
		return dao.addRoom(room);
	}

	/**
	 * M�todo para borrar una habitaci�n
	 * 
	 * @param id
	 * @return
	 * @throws RoomException
	 */
	public String deleteRoom(Long id) throws RoomException {
		return dao.deleteRoom(id);
	}

	/**
	 * M�todo para actualizar la habitaci�n que se pasa por par�metro
	 * 
	 * @param room
	 * @return
	 * @throws RoomException
	 */
	public String updateRoom(Long id, Room room) throws RoomException {
		roomValidator.validate(room);
		room.setId(id);
		return dao.updateRoom(room);
	}

	/**
	 * M�todo para obtener la habitaci�n cuyo id se pasa por par�metro
	 * 
	 * @param id
	 * @return
	 * @throws RoomException
	 */
	public Room listRoom(Long id) throws RoomException {
		return dao.listRoom(id);
	}

	/**
	 * M�todo para obtener la lista de habitaciones de un hotel
	 * 
	 * @return
	 */
	public List<Room> listRoomsOfHotel(Long hotelId) {
		return dao.listRoomsOfHotel(hotelId);
	}

	/**
	 * M�todo para obtener la lista de habitaciones de la reserva que se pasa por
	 * par�metro
	 * 
	 * @return
	 */
	public List<Room> listRoomsOfBooking(Long bookingId) {
		return dao.listRoomsOfBooking(bookingId);
	}

}
