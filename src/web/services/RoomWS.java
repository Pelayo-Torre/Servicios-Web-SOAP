package web.services;

import java.util.List;

import javax.jws.WebService;

import model.Room;
import services.RoomService;
import utils.Constants;

@WebService(endpointInterface = "web.services.IRoomWS")
public class RoomWS implements IRoomWS{

	RoomService roomService = new RoomService();
	
	@Override
	public String add(Room room) {
		roomService.add(room);
		return Constants.RESPONSE_OK;
	}

	@Override
	public String update(Room room) {
		roomService.update(room);
		return Constants.RESPONSE_OK;
	}

	@Override
	public Room getRoom(Long id) {
		return roomService.getRoom(id);
	}

	@Override
	public String delete(Long id) {
		roomService.delete(id);
		return Constants.RESPONSE_OK;
	}

	@Override
	public List<Room> getRoomsOfClient(Long idClient) {
		return roomService.getRoomsOfClient(idClient);
	}

	@Override
	public List<Room> getRoomsOfHotel(Long idHotel) {
		return roomService.getRoomsOfHotel(idHotel);
	}

}
