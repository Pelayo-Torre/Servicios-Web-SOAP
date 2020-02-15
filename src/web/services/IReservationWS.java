package web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import modelo.Reservation;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IReservationWS {
	
	@WebMethod
	public String add(Reservation reservation);
	
	@WebMethod
	public String update(Reservation reservation);
	
	@WebMethod
	public String delete(Long id);
	
	@WebMethod
	public Reservation getReservation(Long id);
	
	@WebMethod
	public Reservation [] getReservations();

}
