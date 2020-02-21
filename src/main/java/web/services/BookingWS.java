package web.services;

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
	public String addBooking(Booking booking) throws BookingException, ParseException {
		return bookingService.addBooking(booking);
	}

	@Override
	public String updateBooking(Long id, Booking booking) throws BookingException, ParseException {
		return bookingService.updateBooking(id, booking);
	}

	@Override
	public String deleteBooking(Long id) throws BookingException, ParseException {
		return bookingService.deleteBooking(id);
	}

	@Override
	public Booking listBooking(Long id) throws ParseException, BookingException {
		return bookingService.listBooking(id);
	}

	@Override
	public List<Booking> listBookings(Long clientId) throws ParseException {
		return bookingService.listBookingsOfClient(clientId);
	}

}
