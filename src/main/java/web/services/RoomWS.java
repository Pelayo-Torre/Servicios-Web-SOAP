package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.RoomException;
import model.Room;
import services.RoomService;

@WebService(endpointInterface = "web.services.IRoomWS")
public class RoomWS implements IRoomWS {

	RoomService roomService = new RoomService();

	@Override
	public String addRoom(Room room) throws RoomException {
		return roomService.addRoom(room);
	}

	@Override
	public String deleteRoom(Long id) throws RoomException {
		return roomService.deleteRoom(id);
	}

	@Override
	public String updateRoom(Long id, Room room) throws RoomException {
		return roomService.updateRoom(id, room);
	}

	@Override
	public Room listRoom(Long id) throws RoomException {
		return roomService.listRoom(id);
	}

	@Override
	public List<Room> listRoomsOfHotel(Long hotelId) {
		return roomService.listRoomsOfHotel(hotelId);
	}
}
