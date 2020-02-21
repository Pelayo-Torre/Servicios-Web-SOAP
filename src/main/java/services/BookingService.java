package services;

import java.text.ParseException;
import java.util.List;

import exception.BookingException;
import model.Booking;
import persistence.BookingDAO;
import persistence.ManagerDAO;
import validators.BookingValidator;

public class BookingService {

	private BookingDAO dao = ManagerDAO.getInstance().getBookingDAO();;
	private BookingValidator bookingValidator = new BookingValidator();

	/**
	 * M�todo para a�adir una reserva
	 * 
	 * @param booking
	 * @return
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String addBooking(Booking booking) throws BookingException, ParseException {
		bookingValidator.validate(booking);
		Booking b = dao.findBookingByCode(booking.getCode());
		if (b == null)
			// TODO revisar codigo de error
			throw new BookingException("La reserva con c�digo =  " + booking.getCode() + " ya existe en el sistema",
					"404");
		return dao.addBooking(booking);
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
