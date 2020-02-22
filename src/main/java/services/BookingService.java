package services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import exception.BookingException;
import exception.ClientException;
import exception.RoomException;
import exception.ServiceException;
import model.Booking;
import model.Client;
import model.Room;
import model.Service;
import persistence.BookingDAO;
import persistence.ClientDAO;
import persistence.ManagerDAO;
import persistence.RoomDAO;
import persistence.ServiceDAO;
import utils.Constants;
import validators.BookingValidator;

public class BookingService {

	private BookingDAO dao = ManagerDAO.getInstance().getBookingDAO();
	private ClientDAO clientDao = ManagerDAO.getInstance().getClientDAO();
	private ServiceDAO serviceDao = ManagerDAO.getInstance().getServiceDAO();
	private RoomDAO roomDao = ManagerDAO.getInstance().getRoomDAO();
	private BookingValidator bookingValidator = new BookingValidator();

	/**
	 * Método para añadir una reserva
	 * 
	 * @param booking
	 * @return
	 * @throws BookingException
	 * @throws ParseException
	 * @throws ClientException 
	 */
	public String addBooking(Booking booking, Long clientId) throws BookingException, ParseException, ClientException {
		bookingValidator.validate(booking);
		
		if(clientId == null)
			throw new ClientException("El Identificador del cliente es obligatorio" , "404");
		
		Client c = clientDao.listClient(clientId);
		
		if(c == null)
			throw new ClientException("El cliente con ID " + clientId + " no existe en el sistema" , "404");
		
		booking.setClient(c);
		booking.setCancelled(Constants.INACTIVE);
		
		return dao.addBooking(booking);
	}
	
	/**
	 * Método para añadir a la reserva la lista de habitaciones que se pasan por parámetro
	 * @param id
	 * @param rooms
	 * @return
	 * @throws BookingException 
	 */
	public String addRoomsToBooking(Long id, List<Room> rooms) throws BookingException {
		Booking b = dao.listBooking(id);
		
		if(b == null)
			throw new BookingException("La reserva con ID " + id + " no se encuentra registrada en el sistema", "404");
		
		List<Long> repetidos = new ArrayList<Long>();
		for (Room r : rooms) {
			if(r.getId() == null)
				throw new RoomException("El identificador de la reserva es obligatorio", "404");
			
			Room room = roomDao.listRoom(r.getId());
			if(room == null)
				throw new RoomException("La habitación con ID " + r.getId() + " no se encuentra registrada", "404");
			
			if(repetidos.contains(r.getId()))
				throw new RoomException("La habitación con ID " + r.getId() + " se encuentra repetida", "404");
			else
				repetidos.add(r.getId());
			
			if(!b.getRooms().contains(room)) {
				b.getRooms().add(room);
				b.addPrice(room.getPrice());
				dao.updateBooking(b);
			}
		}
		return Constants.RESPONSE_OK;
	}
	
	/**
	 * Método para añadir a la reserva la lista de servicios que se pasan por parámetro
	 * @param id
	 * @param services
	 * @return
	 * @throws BookingException 
	 * @throws ServiceException 
	 */
	public String addServicesToBooking(Long id, List<Service> services) throws BookingException, ServiceException {
		Booking b = dao.listBooking(id);
		
		if(b == null)
			throw new BookingException("La reserva con ID " + id + " no se encuentra registrada en el sistema", "404");
		
		List<Long> repetidos = new ArrayList<Long>();
		for (Service s : services) {
			if(s.getId() == null)
				throw new ServiceException("El identificador del servicio es obligatorio", "404");
			
			Service service = serviceDao.listService(s.getId());
			if(service == null)
				throw new ServiceException("El servicio con ID " + s.getId() + " no está registrado en el sistema", "404");
			
			if(repetidos.contains(s.getId()))
				throw new ServiceException("El servicio con ID " + s.getId() + " se encuentra repetido", "404");
			else
				repetidos.add(s.getId());
			
			if(!b.getServices().contains(service)) {
				b.getServices().add(service);	
				b.addPrice(service.getPrice());
				dao.updateBooking(b);
			}
		}
		return Constants.RESPONSE_OK;
	}
	
	public String removeServicesToBooking(Long idBooking, List<Service> listService) throws BookingException, ServiceException {
		Booking b = dao.listBooking(idBooking);
		
		if(b == null)
			throw new BookingException("La reserva con ID " + idBooking + " no se encuentra registrada en el sistema", "404");
		
		List<Long> repetidos = new ArrayList<Long>();
		for (Service s : listService) {
			if(s.getId() == null)
				throw new ServiceException("El identificador del servicio es obligatorio", "404");
			
			Service service = serviceDao.listService(s.getId());
			if(service == null)
				throw new ServiceException("El servicio con ID " + s.getId() + " no está registrado en el sistema", "404");
			
			if(repetidos.contains(s.getId()))
				throw new ServiceException("El servicio con ID " + s.getId() + " se encuentra repetido", "404");
			else
				repetidos.add(s.getId());
			
			if(b.getServices().contains(service)) {
				b.getServices().remove(service);	
				b.subPrice(service.getPrice());
				dao.updateBooking(b);
			}
		}
		return Constants.RESPONSE_OK;
	}
	
	public String removeRoomsToBooking(Long idBooking, List<Room> listRoom) throws BookingException {
		Booking b = dao.listBooking(idBooking);
		
		if(b == null)
			throw new BookingException("La reserva con ID " + idBooking + " no se encuentra registrada en el sistema", "404");
		
		List<Long> repetidos = new ArrayList<Long>();
		for(Room room : listRoom) {
			if(room.getId() == null)
				throw new RoomException("El identificador de la habitación es obligatorio", "404");
			
			Room r = roomDao.listRoom(room.getId());
			if(r == null)
				throw new RoomException("La habitación con ID " + room.getId() + " no está registrada en el sistema", "404");
			
			if(repetidos.contains(room.getId()))
				throw new RoomException("La habitación con ID " + room.getId() + " no se encuentra registrada en el sistema", "404");
			else
				repetidos.add(room.getId());
			
			if(b.getRooms().contains(r)) {
				b.getRooms().remove(r);
				b.subPrice(r.getPrice());
				dao.updateBooking(b);
			}
		}
		return Constants.RESPONSE_OK;
	}

	/**
	 * Método para borrar una reserva
	 * 
	 * @param id
	 * @return
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String deleteBooking(Long id) throws BookingException, ParseException {
		Booking booking = dao.listBooking(id);
		
		if(booking == null)
			throw new BookingException("La reserva con ID " + id + " no existe en el sistema", "404");
		
		booking.setCancelled(Constants.ACTIVE);
		
		return updateBooking(booking);
	}

	/**
	 * Método para actualizar la reserva que se pasa por parámetro
	 * 
	 * @param booking
	 * @return
	 * @throws BookingException
	 * @throws ParseException
	 */
	public String updateBooking(Booking booking) throws BookingException, ParseException {
		bookingValidator.validate(booking);
		
		if(booking.getCancelled() == null)
			booking.setCancelled(0);
		else if(booking.getCancelled() != 0 && booking.getCancelled() != 1)
			throw new BookingException("El campo cancelador de la reserva es incorrecto", "404");
		
		if(dao.listBooking(booking.getId()) == null)
			throw new BookingException("La reserva con ID " + booking.getId() + " no existe en el sistema", "404");
		
		Client client = clientDao.getClientOfBooking(booking.getId());
		
		booking.setClient(client);
		return dao.updateBooking(booking);
	}

	/**
	 * Método para obtener la reserva cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws ParseException
	 * @throws BookingException
	 */
	public Booking listBooking(Long id) throws BookingException {
		Booking booking =  dao.listBooking(id);
		
		if(booking == null)
			throw new BookingException("La reserva con id =  " + id + " no existe.", "404");
		
		return booking;
	}

	/**
	 * Método para obtener la lista de reservas asociadas al cliente que se pasa por
	 * parametro
	 * 
	 * @return
	 * @throws ParseException
	 * @throws ClientException 
	 */
	public List<Booking> listBookingsOfClient(Long clientId) throws ClientException {
		
		if(clientDao.listClient(clientId) == null)
			throw new ClientException("El cliente con ID " + clientId + " no está registrado en el sistema", "404");
		
		return dao.listBookingsOfClient(clientId);
	}
	

}
