package web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Booking;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IBookingWS {
	
	@WebMethod
	public String add(Booking reservation);
	
	@WebMethod
	public String update(Booking reservation);
	
	@WebMethod
	public String delete(Long id);
	
	@WebMethod
	public Booking getReservation(Long id);
	
	@WebMethod
	public Booking [] getReservations();

}
