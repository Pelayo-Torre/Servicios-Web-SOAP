package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Room;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IRoomWS {
	
	@WebMethod
	public String addRoom(Room room);
	
	@WebMethod
	public String deleteRoom(Long id);
	
	@WebMethod
	public String updateRoom(Long id, Room room);

	@WebMethod
	public Room listRoom(Long id);
	
	@WebMethod
	public List<Room> listRoomsOfHotel(Long hotelId);
	
	@WebMethod
	public List<Room> listRoomsOfBooking(Long bookingId);
	
}
