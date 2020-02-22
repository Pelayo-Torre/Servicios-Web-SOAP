package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.BookingException;
import exception.HotelException;
import exception.RoomException;
import model.dtos.RoomAddDTO;
import model.dtos.RoomDTO;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IRoomWS {

	@WebMethod
	public String addRoom(RoomAddDTO room) throws RoomException, HotelException;

	@WebMethod
	public String deleteRoom(Long id) throws RoomException;

	@WebMethod
	public String updateRoom(RoomDTO room) throws RoomException;

	@WebMethod
	public RoomDTO listRoom(Long id) throws RoomException;

	@WebMethod
	public List<RoomDTO> listRoomsOfHotel(Long hotelId) throws HotelException;
	
	@WebMethod
	public List<RoomDTO> listRoomsOfBooking(Long bookingId) throws BookingException;

}
