package web.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.BookingException;
import model.Booking;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IBookingWS {

	@WebMethod
	public String addBooking(Booking booking) throws SQLException, BookingException, ParseException;

	@WebMethod
	public String updateBooking(Long id, Booking booking) throws BookingException, SQLException, ParseException;

	@WebMethod
	public String deleteBooking(Long id) throws BookingException, SQLException, ParseException;

	@WebMethod
	public Booking listBooking(Long id) throws SQLException, ParseException;

	@WebMethod
	public List<Booking> listBookings(Long clientId) throws SQLException, ParseException;

}
