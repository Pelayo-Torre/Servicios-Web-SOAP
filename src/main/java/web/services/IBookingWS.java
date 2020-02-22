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
import model.Room;
import model.dtos.BookingAddDTO;
import model.dtos.BookingDTO;
import model.dtos.RoomDTO;
import model.dtos.ServiceDTO;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IBookingWS {

	@WebMethod
	public String addBooking(BookingAddDTO booking) throws BookingException, ParseException, ClientException;
	
	@WebMethod
	public String addRoomsToBooking(Long idBooking, List<RoomDTO> rooms) throws RoomException, BookingException;
	
	@WebMethod
	public String addServicesToBooking(Long idBooking, List<ServiceDTO> services) throws ServiceException, BookingException;
	
	@WebMethod
	public String removeServicesToBooking(Long idBooking, List<ServiceDTO> services) throws ServiceException, BookingException;
	
	@WebMethod
	public String removeRoomsToBooking(Long idBooking, List<RoomDTO> services) throws RoomException, BookingException;

	@WebMethod
	public String updateBooking(BookingDTO booking) throws BookingException, ParseException;

	@WebMethod
	public String deleteBooking(Long id) throws BookingException, ParseException;

	@WebMethod
	public BookingDTO listBooking(Long id) throws BookingException;

	@WebMethod
	public List<BookingDTO> listBookingsOfClient(Long clientId) throws ClientException;

}
