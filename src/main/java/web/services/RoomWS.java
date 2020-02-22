package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.BookingException;
import exception.HotelException;
import exception.RoomException;
import model.dtos.DTOAssembler;
import model.dtos.RoomAddDTO;
import model.dtos.RoomDTO;
import services.RoomService;

@WebService(endpointInterface = "web.services.IRoomWS")
public class RoomWS implements IRoomWS {

	RoomService roomService = new RoomService();

	@Override
	public String addRoom(RoomAddDTO room) throws RoomException, HotelException {
		return roomService.addRoom(DTOAssembler.toEntity(room), room.getIdHotel());
	}

	@Override
	public String deleteRoom(Long id) throws RoomException {
		return roomService.deleteRoom(id);
	}

	@Override
	public String updateRoom(RoomDTO room) throws RoomException {
		return roomService.updateRoom(DTOAssembler.toEntity(room));
	}

	@Override
	public RoomDTO listRoom(Long id) throws RoomException {
		return DTOAssembler.toDTO(roomService.listRoom(id));
	}

	@Override
	public List<RoomDTO> listRoomsOfHotel(Long hotelId) throws HotelException {
		return DTOAssembler.toListDTORoom(roomService.listRoomsOfHotel(hotelId));
	}

	@Override
	public List<RoomDTO> listRoomsOfBooking(Long bookingId) throws BookingException {
		return DTOAssembler.toListDTORoom(roomService.listRoomsOfBooking(bookingId));
	}
}
