package web.services;

import java.util.List;

import javax.jws.WebService;

import model.Booking;
import services.BookingService;
import utils.Constants;

@WebService(endpointInterface = "web.services.IBookingWS")
public class BookingWS implements IBookingWS{

	private BookingService bookingService = new BookingService();
	
	@Override
	public String add(Booking booking) {
		bookingService.add(booking);
		return Constants.RESPONSE_OK;
	}

	@Override
	public String update(Booking booking) {
		bookingService.update(booking);
		return null;
	}

	@Override
	public String delete(Long id) {
		bookingService.delete(id);
		return Constants.RESPONSE_OK;
	}

	@Override
	public Booking getBooking(Long id) {
		return bookingService.getBooking(id);
	}

	@Override
	public List<Booking> getBookings(Long idClient) {
		return bookingService.getBookings(idClient);
	}

}
