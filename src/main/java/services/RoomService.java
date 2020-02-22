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
import utils.Constants;
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
		
		if(hotelId == null)
			throw new HotelException("El Idenificador del hotel es obligatorio", "404");
		
		Hotel h = hotelDao.listHotel(hotelId);
		if(h == null)
			throw new HotelException("El hotel con ID = " + hotelId + " no existe en el sistema", "404");
		
		Room r = dao.findRoomByCode(room.getCode());
		if (r != null)
			throw new RoomException("La habitaci�n con c�digo =  " + room.getCode() + " ya existe en el sistema","404");
		
		room.setHotel(h);
		room.setActive(Constants.ACTIVE);
		
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
		Room r = dao.listRoom(id);
		
		if(r == null)
			throw new RoomException("La habitaci�n con ID " + id + " no est� registrada en el sistema", "404");
		
		r.setActive(Constants.ACTIVE);
		return updateRoom(r);
	}

	/**
	 * M�todo para actualizar la habitaci�n que se pasa por par�metro
	 * 
	 * @param room
	 * @return
	 * @throws RoomException
	 */
	public String updateRoom(Room room) throws RoomException {
		roomValidator.validate(room);
		
		if(room.getActive() == null)
			room.setActive(Constants.ACTIVE);
		else if(room.getActive() != 0 && room.getActive() != 1)
			throw new RoomException("El campo active de la habitaci�n es incorrecto", "404");
		
		if(dao.listRoom(room.getId()) == null)
			throw new RoomException("La habitaci�n con ID " + room.getId() + " no est� registrada en el sistema", "404");
		
		Hotel hotel = hotelDao.getHotelOfRoom(room.getId());
		
		room.setHotel(hotel);
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
		Room room = dao.listRoom(id);
		
		if(room == null)
			throw new RoomException("La habitaci�n con ID " + id + " no est� registrada en el sistema", "404");
		
		return room;
	}

	/**
	 * M�todo para obtener la lista de habitaciones de un hotel
	 * 
	 * @return
	 * @throws HotelException 
	 */
	public List<Room> listRoomsOfHotel(Long hotelId) throws HotelException {
		if(hotelDao.listHotel(hotelId) == null)
			throw new HotelException("El hotel con ID " + hotelId + " no est� registrado en el sistema", "404");
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
		
		if(b == null)
			throw new BookingException("La reserva con ID " + bookingId + " no est� registrada en el sistema", "404");
		
		return b.getRooms().stream().collect(Collectors.toList());
	}

}
