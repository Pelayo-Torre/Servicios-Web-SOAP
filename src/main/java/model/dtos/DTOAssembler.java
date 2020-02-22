package model.dtos;

import java.util.ArrayList;
import java.util.List;

import model.Booking;
import model.Client;
import model.Room;
import model.RoomType;
import model.Service;

public class DTOAssembler {
	
	public static Client toEntity(ClientDTO dto) {
		Client client = new Client();
		
		client.setDni(dto.getDni());
		client.setEmail(dto.getEmail());
		client.setId(dto.getIdClient());
		client.setName(dto.getName());
		client.setTelephone(dto.getTelephone());
		client.setActive(dto.getActive());
		
		return client;
	}
	
	public static Client toEntity(ClientAddDTO dto) {
		Client client = new Client();
		
		client.setDni(dto.getDni());
		client.setEmail(dto.getEmail());
		client.setName(dto.getName());
		client.setTelephone(dto.getTelephone());
		
		return client;
	}

	public static ClientDTO toDTO(Client client) {
		ClientDTO dto = new ClientDTO();
		
		dto.setDni(client.getDni());
		dto.setEmail(client.getEmail());
		dto.setIdClient(client.getId());
		dto.setName(client.getName());
		dto.setTelephone(client.getTelephone());
		dto.setActive(client.getActive());
		
		return dto;
	}
	
	public static List<ClientDTO> toListDTO(List<Client> clients){
		List<ClientDTO> list = new ArrayList<ClientDTO>();
		
		for(Client c : clients) {
			ClientDTO dto = toDTO(c);
			list.add(dto);
		}
		
		return list;
	}
	
	public static Booking toEntity(BookingDTO dto) {
		Booking booking = new Booking();
		
		booking.setEndDate(dto.getEndDate());
		booking.setId(dto.getIdBooking());
		booking.setPrice(dto.getPrice());
		booking.setStartDate(dto.getStartDate());
		booking.setCancelled(dto.getCancelled());
		
		return booking;
	}
	
	public static Booking toEntity(BookingAddDTO dto) {
		Booking booking = new Booking();
		
		booking.setEndDate(dto.getEndDate());
		booking.setStartDate(dto.getStartDate());
		
		return booking;
	}
	
	public static BookingDTO toDTO(Booking booking) {
		BookingDTO dto = new BookingDTO();
		
		dto.setEndDate(booking.getEndDate());
		dto.setIdBooking(booking.getId());
		dto.setPrice(booking.getPrice());
		dto.setStartDate(booking.getStartDate());
		dto.setCancelled(booking.getCancelled());
		
		return dto;
	}
	
	public static List<BookingDTO> toListDTOBooking(List<Booking> bookings){
		List<BookingDTO> list = new ArrayList<BookingDTO>();
		
		for(Booking c : bookings) {
			BookingDTO dto = toDTO(c);
			list.add(dto);
		}
		
		return list;
	}
	
	public static Service toEntity(ServiceDTO dto) {
		Service service = new Service();
		
		service.setId(dto.getId());
		service.setName(dto.getName());
		service.setPrice(dto.getPrice());
		service.setActive(dto.getActive());
		
		return service;
	}
	
	public static Service toEntity(ServiceAddDTO dto) {
		Service service = new Service();
		
		service.setName(dto.getName());
		service.setPrice(dto.getPrice());
		
		return service;
	}
	
	public static ServiceDTO toDTO(Service service) {
		ServiceDTO dto = new ServiceDTO();
		
		dto.setId(service.getId());
		dto.setName(service.getName());
		dto.setPrice(service.getPrice());
		dto.setActive(service.getActive());
		
		return dto;
	}
	
	public static List<ServiceDTO> toListDTOService(List<Service> services){
		List<ServiceDTO> list = new ArrayList<ServiceDTO>();
		
		for(Service c : services) {
			ServiceDTO dto = toDTO(c);
			list.add(dto);
		}
		
		return list;
	}
	
	public static List<Service> toListService(List<ServiceDTO> services){
		List<Service> list = new ArrayList<Service>();
		
		for(ServiceDTO c : services) {
			Service service = toEntity(c);
			list.add(service);
		}
		
		return list;
	}
	
	public static Room toEntity(RoomDTO dto) {
		Room room = new Room();
		
		room.setId(dto.getId());
		room.setActive(dto.getActive());
		room.setCode(dto.getCode());
		room.setPrice(dto.getPrice());
		if(dto.getType() != null) {
			if(dto.getType() == 1)
				room.setRoomType(RoomType.INDIVIDUAL);
			else if(dto.getType() == 2)
				room.setRoomType(RoomType.DOUBLE);
			else if(dto.getType() == 3)
				room.setRoomType(RoomType.MARRIAGE);
		}
		
		return room;
	}
	
	public static Room toEntity(RoomAddDTO dto) {
		Room room = new Room();
		
		room.setCode(dto.getCode());
		room.setPrice(dto.getPrice());
		if(dto.getType() != null) {
			if(dto.getType() == 1)
				room.setRoomType(RoomType.INDIVIDUAL);
			else if(dto.getType() == 2)
				room.setRoomType(RoomType.DOUBLE);
			else if(dto.getType() == 3)
				room.setRoomType(RoomType.MARRIAGE);
		}

		return room;
	}
	
	public static RoomDTO toDTO(Room room) {
		RoomDTO dto = new RoomDTO();
		
		dto.setId(room.getId());
		dto.setCode(room.getCode());
		dto.setPrice(room.getPrice());
		dto.setType(room.getRoomType().ordinal());
		dto.setActive(room.getActive());
		
		return dto;
	}
	
	public static List<RoomDTO> toListDTORoom(List<Room> rooms){
		List<RoomDTO> list = new ArrayList<RoomDTO>();
		
		for(Room c : rooms) {
			RoomDTO dto = toDTO(c);
			list.add(dto);
		}
		
		return list;
	}
	
	public static List<Room> toListRoom(List<RoomDTO> rooms){
		List<Room> list = new ArrayList<Room>();
		
		for(RoomDTO c : rooms) {
			Room room = toEntity(c);
			list.add(room);
		}
		
		return list;
	}
	
}
