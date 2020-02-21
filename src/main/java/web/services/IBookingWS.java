package web.services;

import java.text.ParseException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.BookingException;
import exception.ClientException;
import exception.RoomException;
import exception.ServiceException;
import model.Booking;
import model.Room;
import model.Service;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IBookingWS {

	@WebMethod
	public String addBooking(Booking booking, Long clientId) throws BookingException, ParseException, ClientException;
	
	@WebMethod
	public String addRoomsToBooking(Long id, List<Room> rooms) throws RoomException, BookingException;
	
	@WebMethod
	public String addServicesToBooking(Long id, List<Service> services) throws ServiceException, BookingException;

	@WebMethod
	public String updateBooking(Long id, Booking booking) throws BookingException, ParseException;

	@WebMethod
	public String deleteBooking(Long id) throws BookingException, ParseException;

	@WebMethod
	public Booking listBooking(Long id) throws ParseException, BookingException;

	@WebMethod
	public List<Booking> listBookingsOfClient(Long clientId) throws ParseException;

}
