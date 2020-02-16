package web.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import model.Booking;
import utils.Constants;

@WebService(endpointInterface = "web.services.IReservationWS")
public class BookingWS implements IBookingWS{

	List<Booking> reservations = new ArrayList<Booking>();
 	
	@Override
	public String add(Booking reservation) {
		reservations.add(reservation);
		return Constants.RESPONSE_OK;
	}

	@Override
	public String update(Booking reservation) {
		return null;
	}

	@Override
	public String delete(Long id) {
		return null;
	}

	@Override
	public Booking getReservation(Long id) {
		return null;
	}

	@Override
	public Booking[] getReservations() {
		Booking [] array = new Booking [reservations.size()];
		reservations.toArray(array);
		return array;
	}

}
