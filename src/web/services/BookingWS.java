package web.services;

import java.util.ArrayList;
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
		
		return Constants.RESPONSE_OK;
	}

	@Override
	public String update(Long id, Booking booking) {
		
		return null;
	}

	@Override
	public String delete(Long id) {
		
		return Constants.RESPONSE_OK;
	}

	@Override
	public Booking listBooking(Long id) {
		return null;
	}

	@Override
	public List<Booking> listBookings(Long idClient) {
		return new ArrayList<Booking>();
	}

}
