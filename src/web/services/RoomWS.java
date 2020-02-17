package web.services;

import java.util.List;

import javax.jws.WebService;

import model.Room;
import services.RoomService;

@WebService(endpointInterface = "web.services.IRoomWS")
public class RoomWS implements IRoomWS{

	RoomService roomService = new RoomService();

	@Override
	public String addRoom(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteRoom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRoom(Long id, Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room listRoom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> listRoomsOfHotel(Long hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> listRoomsOfBooking(Long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
