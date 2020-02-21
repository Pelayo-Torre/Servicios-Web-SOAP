package web.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.jws.WebService;

import exception.BookingException;
import model.Booking;
import services.BookingService;

@WebService(endpointInterface = "web.services.IBookingWS")
public class BookingWS implements IBookingWS {

	private BookingService bookingService = new BookingService();

	@Override
	public String addBooking(Booking booking) throws SQLException, BookingException, ParseException {
		return bookingService.addBooking(booking);
	}

	@Override
	public String updateBooking(Long id, Booking booking) throws BookingException, SQLException, ParseException {
		return bookingService.updateBooking(id, booking);
	}

	@Override
	public String deleteBooking(Long id) throws BookingException, SQLException, ParseException {
		return bookingService.deleteBooking(id);
	}

	@Override
	public Booking listBooking(Long id) throws SQLException, ParseException {
		return bookingService.listBooking(id);
	}

	@Override
	public List<Booking> listBookings(Long clientId) throws SQLException, ParseException {
		return bookingService.listBookingsOfClient(clientId);
	}

}
