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
	 * Método para añadir una habitacion
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
			throw new RoomException("La habitación con código =  " + room.getCode() + " ya existe en el sistema","404");
		
		Hotel h = hotelDao.listHotel(hotelId);
		room.setHotel(h);
		room.setType(room.getRoomType().name());
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
	 * @throws BookingException 
	 */
	public List<Room> listRoomsOfBooking(Long bookingId) throws BookingException {
		Booking b = bookingDao.listBooking(bookingId);
		return b.getRooms().stream().collect(Collectors.toList());
	}

}
