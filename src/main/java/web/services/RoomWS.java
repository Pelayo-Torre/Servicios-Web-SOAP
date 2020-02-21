package web.services;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import exception.RoomException;
import model.Room;
import services.RoomService;

@WebService(endpointInterface = "web.services.IRoomWS")
public class RoomWS implements IRoomWS{

	RoomService roomService = new RoomService();

	@Override
	public String addRoom(Room room) throws RoomException, SQLException {
		return roomService.addRoom(room);
	}

	@Override
	public String deleteRoom(Long id) throws RoomException, SQLException {
		return roomService.deleteRoom(id);
	}

	@Override
	public String updateRoom(Long id, Room room) throws RoomException, SQLException {
		return roomService.updateRoom(id, room);
	}

	@Override
	public Room listRoom(Long id) throws SQLException {
		return roomService.listRoom(id);
	}

	@Override
	public List<Room> listRoomsOfHotel(Long hotelId) throws SQLException {
		return roomService.listRoomsOfHotel(hotelId);
	}
}
