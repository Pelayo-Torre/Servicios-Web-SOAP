package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.RoomException;
import model.Room;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IRoomWS {

	@WebMethod
	public String addRoom(Room room) throws RoomException;

	@WebMethod
	public String deleteRoom(Long id) throws RoomException;

	@WebMethod
	public String updateRoom(Long id, Room room) throws RoomException;

	@WebMethod
	public Room listRoom(Long id) throws RoomException;

	@WebMethod
	public List<Room> listRoomsOfHotel(Long hotelId);

}
