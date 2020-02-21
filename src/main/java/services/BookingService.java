package services;

import java.text.ParseException;
import java.util.List;

import exception.BookingException;
import exception.ClientException;
import model.Booking;
import model.Client;
import model.Room;
import model.Service;
import persistence.BookingDAO;
import persistence.ClientDAO;
import persistence.ManagerDAO;
import validators.BookingValidator;

public class BookingService {

	private BookingDAO dao = ManagerDAO.getInstance().getBookingDAO();
	private ClientDAO clientDao = ManagerDAO.getInstance().getClientDAO();
	private BookingValidator bookingValidator = new BookingValidator();

	/**
	 * M�todo para a�adir una reserva
	 * 
	 * @param booking
	 * @return
	 * @throws BookingException
	 * @throws ParseException
	 * @throws ClientException 
	 */
	public String addBooking(Booking booking, Long clientId) throws BookingException, ParseException, ClientException {
		bookingValidator.validate(booking);
		Booking b = dao.findBookingByCode(booking.getCode());
		if (b != null)
			throw new BookingException("La reserva con c�digo =  " + booking.getCode() + " ya existe en el sistema",
					"404");
		
		Client c = clientDao.listClient(clientId);
		booking.setClient(c);
		
		return dao.addBooking(booking);
	}
	
	/**
	 * M�todo para a�adir a la reserva la lista de habitaciones que se pasan por par�metro
	 * @param id
	 * @param rooms
	 * @return
	 * @throws BookingException 
	 */
	public String addRoomsToBooking(Long id, List<Room> rooms) throws BookingException {
		Booking b = dao.listBooking(id);
		for (Room r : rooms)
			b.getRooms().add(r);
		return dao.updateBooking(b);
	}
	
	/**
	 * M�todo para a�adir a la reserva la lista de servicios que se pasan por par�metro
	 * @param id
	 * @param services
	 * @return
	 * @throws BookingException 
	 */
	public String addServicesToBooking(Long id, List<Service> services) throws BookingException {
		Booking b = dao.listBooking(id);
		for (Service s : services)
			b.getServices().add(s);
		return dao.updateBooking(b);
	}

	/**
	 * M�todo para borrar una reserva
	 * 
	 * @param id
	 * @return
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String deleteBooking(Long id) throws BookingException, ParseException {
		return dao.deleteBooking(id);
	}

	/**
	 * M�todo para actualizar la reserva que se pasa por par�metro
	 * 
	 * @param booking
	 * @return
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String updateBooking(Long id, Booking booking) throws BookingException, ParseException {
		bookingValidator.validate(booking);
		booking.setId(id);
		return dao.updateBooking(booking);
	}

	/**
	 * M�todo para obtener la reserva cuyo id se pasa por par�metro
	 * 
	 * @param id
	 * @return
	 * @throws ParseException
	 * @throws BookingException
	 */
	public Booking listBooking(Long id) throws ParseException, BookingException {
		return dao.listBooking(id);
	}

	/**
	 * M�todo para obtener la lista de reservas asociadas al cliente que se pasa por
	 * parametro
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<Booking> listBookingsOfClient(Long clientId) throws ParseException {
		return dao.listBookingsOfClient(clientId);
	}

}
