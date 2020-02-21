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
	 * Método para añadir una habitacion
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
	 * Método para borrar una habitación
	 * 
	 * @param id
	 * @return
	 * @throws RoomException
	 */
	public String deleteRoom(Long id) throws RoomException {
		return dao.deleteRoom(id);
	}

	/**
	 * Método para actualizar la habitación que se pasa por parámetro
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
	 * Método para obtener la habitación cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws RoomException
	 */
	public Room listRoom(Long id) throws RoomException {
		return dao.listRoom(id);
	}

	/**
	 * Método para obtener la lista de habitaciones de un hotel
	 * 
	 * @return
	 */
	public List<Room> listRoomsOfHotel(Long hotelId) {
		return dao.listRoomsOfHotel(hotelId);
	}

	/**
	 * Método para obtener la lista de habitaciones de la reserva que se pasa por
	 * parámetro
	 * 
	 * @return
	 */
	public List<Room> listRoomsOfBooking(Long bookingId) {
		return dao.listRoomsOfBooking(bookingId);
	}

}
