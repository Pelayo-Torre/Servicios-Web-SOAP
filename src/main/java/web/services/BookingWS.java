package web.services;

import java.text.ParseException;
import java.util.List;

import javax.jws.WebService;

import exception.BookingException;
import exception.ClientException;
import exception.ServiceException;
import model.Booking;
import model.Room;
import model.Service;
import services.BookingService;

@WebService(endpointInterface = "web.services.IBookingWS")
public class BookingWS implements IBookingWS {

	private BookingService bookingService = new BookingService();

	@Override
	public String addBooking(Booking booking, Long hotelId) throws BookingException, ParseException, ClientException {
		return bookingService.addBooking(booking, hotelId);
	}
	
	@Override
	public String addRoomsToBooking(Long id, List<Room> rooms) throws BookingException {
		return bookingService.addRoomsToBooking(id, rooms);
	}

	@Override
	public String addServicesToBooking(Long id, List<Service> services) throws ServiceException, BookingException {
		return bookingService.addServicesToBooking(id, services);
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
	public List<Booking> listBookingsOfClient(Long clientId) throws ParseException {
		return bookingService.listBookingsOfClient(clientId);
	}

}
