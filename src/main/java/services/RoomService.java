package services;

import java.util.List;
import java.util.stream.Collectors;

import exception.BookingException;
import exception.HotelException;
import exception.RoomException;
import model.Booking;
import model.Hotel;
import model.Room;
import persistence.BookingDAO;
import persistence.HotelDAO;
import persistence.ManagerDAO;
import persistence.RoomDAO;
import validators.RoomValidator;

public class RoomService {

	private RoomDAO dao = ManagerDAO.getInstance().getRoomDAO();
	private HotelDAO hotelDao = ManagerDAO.getInstance().getHotelDAO();
	private BookingDAO bookingDao = ManagerDAO.getInstance().getBookingDAO();
	private RoomValidator roomValidator = new RoomValidator();

	/**
	 * M�todo para a�adir una habitacion
	 * 
	 * @param room
	 * @return
	 * @throws RoomException
	 * @throws HotelException 
	 */
	public String addRoom(Room room, Long hotelId) throws RoomException, HotelException {
		roomValidator.validate(room);
		Room r = dao.findRoomByCode(room.getCode());
		if (r != null)
			throw new RoomException("La habitaci�n con c�digo =  " + room.getCode() + " ya existe en el sistema","404");
		
		Hotel h = hotelDao.listHotel(hotelId);
		room.setHotel(h);
		room.setType(room.getRoomType().name());
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
	 * @throws BookingException 
	 */
	public List<Room> listRoomsOfBooking(Long bookingId) throws BookingException {
		Booking b = bookingDao.listBooking(bookingId);
		return b.getRooms().stream().collect(Collectors.toList());
	}

}
