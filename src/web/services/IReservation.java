package web.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import modelo.Reservation;
import utils.Constantes;

@WebService(endpointInterface = "web.services.IReservationWS")
public class IReservation implements IReservationWS{

	List<Reservation> reservations = new ArrayList<Reservation>();
 	
	@Override
	public String add(Reservation reservation) {
		reservations.add(reservation);
		return Constantes.RESPONSE_OK;
	}

	@Override
	public String update(Reservation reservation) {
		return null;
	}

	@Override
	public String delete(Long id) {
		return null;
	}

	@Override
	public Reservation getReservation(Long id) {
		return null;
	}

	@Override
	public Reservation[] getReservations() {
		Reservation [] array = new Reservation [reservations.size()];
		reservations.toArray(array);
		return array;
	}

}
