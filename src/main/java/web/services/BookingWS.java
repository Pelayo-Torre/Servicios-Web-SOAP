package web.services;

import java.text.ParseException;
import java.util.List;

import javax.jws.WebService;

import exception.BookingException;
import exception.ClientException;
import exception.RoomException;
import exception.ServiceException;
import model.Room;
import model.dtos.BookingAddDTO;
import model.dtos.BookingDTO;
import model.dtos.DTOAssembler;
import model.dtos.RoomDTO;
import model.dtos.ServiceDTO;
import services.BookingService;

@WebService(endpointInterface = "web.services.IBookingWS")
public class BookingWS implements IBookingWS {

	private BookingService bookingService = new BookingService();

	@Override
	public String addBooking(BookingAddDTO booking) throws BookingException, ParseException, ClientException {
		return bookingService.addBooking(DTOAssembler.toEntity(booking), booking.getIdClient());
	}
	
	@Override
	public String addRoomsToBooking(Long id, List<RoomDTO> rooms) throws BookingException {
		return bookingService.addRoomsToBooking(id, DTOAssembler.toListRoom(rooms));
	}

	@Override
	public String addServicesToBooking(Long id, List<ServiceDTO> services) throws ServiceException, BookingException {
		return bookingService.addServicesToBooking(id, DTOAssembler.toListService(services));
	}

	@Override
	public String updateBooking(BookingDTO dto) throws BookingException, ParseException {
		return bookingService.updateBooking(DTOAssembler.toEntity(dto));
	}

	@Override
	public String deleteBooking(Long id) throws BookingException, ParseException {
		return bookingService.deleteBooking(id);
	}

	@Override
	public BookingDTO listBooking(Long id) throws BookingException {
		return DTOAssembler.toDTO(bookingService.listBooking(id));
	}

	@Override
	public List<BookingDTO> listBookingsOfClient(Long clientId) throws  ClientException {
		return DTOAssembler.toListDTOBooking(bookingService.listBookingsOfClient(clientId));
	}

	@Override
	public String removeServicesToBooking(Long idBooking, List<ServiceDTO> services)
			throws ServiceException, BookingException {
		return bookingService.removeServicesToBooking(idBooking, DTOAssembler.toListService(services));

	}

	@Override
	public String removeRoomsToBooking(Long idBooking, List<RoomDTO> rooms) throws RoomException, BookingException {
		return bookingService.removeRoomsToBooking(idBooking, DTOAssembler.toListRoom(rooms));
	}

}
