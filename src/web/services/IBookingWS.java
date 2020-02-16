package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Booking;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IBookingWS {
	
	@WebMethod
	public String add(Booking booking);
	
	@WebMethod
	public String update(Long id, Booking booking);
	
	@WebMethod
	public String delete(Long id);
	
	@WebMethod
	public Booking listBooking(Long id);
	
	@WebMethod
	public List<Booking> listBookings(Long idClient);

}
