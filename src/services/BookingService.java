package services;

import java.sql.SQLException;
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
	 * Método para añadir una reserva
	 * 
	 * @param booking
	 * @return
	 * @throws SQLException
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String addBooking(Booking booking) throws SQLException, BookingException, ParseException {
		bookingValidator.validate(booking);
		booking.setCancelled(false);
		return dao.addBooking(booking);
	}

	/**
	 * Método para borrar una reserva
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String deleteBooking(Long id) throws SQLException, BookingException, ParseException {
		Booking b = dao.listBooking(id);
		if (b == null)
			throw new BookingException("La reserva que se desea eliminar no existe", "404");

		return dao.deleteBooking(id);
	}

	/**
	 * Método para actualizar la reserva que se pasa por parámetro
	 * 
	 * @param booking
	 * @return
	 * @throws SQLException
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String updateBooking(Long id, Booking booking) throws SQLException, BookingException, ParseException {
		bookingValidator.validate(booking);
		Booking b = dao.listBooking(id);
		if (b == null)
			throw new BookingException("La reserva que se desea eliminar no existe", "404");
		booking.setId(id);
		return dao.updateBooking(booking);
	}

	/**
	 * Método para obtener la reserva cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	public Booking listBooking(Long id) throws SQLException, ParseException {
		return dao.listBooking(id);
	}

	/**
	 * Método para obtener la lista de reservas asociadas al cliente que se pasa por
	 * parametro
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	public List<Booking> listBookings(Long clientId) throws SQLException, ParseException {
		return dao.listBookings(clientId);
	}

}
