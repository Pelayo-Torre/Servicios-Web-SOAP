package services;

import java.util.List;
import java.util.stream.Collectors;

import exception.BookingException;
import exception.HotelException;
import exception.ServiceException;
import model.Booking;
import model.Hotel;
import model.Service;
import persistence.BookingDAO;
import persistence.HotelDAO;
import persistence.ManagerDAO;
import persistence.ServiceDAO;
import utils.Constants;
import validators.ServiceValidator;

public class ServiceService {

	private ServiceDAO dao = ManagerDAO.getInstance().getServiceDAO();
	private HotelDAO hotelDao = ManagerDAO.getInstance().getHotelDAO();
	private BookingDAO bookingDao = ManagerDAO.getInstance().getBookingDAO();
	private ServiceValidator serviceValidator = new ServiceValidator();

	/**
	 * M�todo para a�adir un servicio
	 * 
	 * @param service
	 * @return
	 * @throws ServiceException
	 * @throws HotelException
	 */
	public String addService(Service service, Long hotelId) throws ServiceException, HotelException {
		serviceValidator.validate(service);
		
		if(hotelId == null)
			throw new HotelException("El Idenificador del hotel es obligatorio", "404");

		Hotel h = hotelDao.listHotel(hotelId);
		
		if(h == null)
			throw new HotelException("El hotel con ID = " + hotelId + " no existe en el sistema", "404");
		
		service.setHotel(h);
		service.setActive(Constants.ACTIVE);
		
		return dao.addService(service);
	}

	/**
	 * M�todo para borrar un servicio
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public String deleteService(Long id) throws ServiceException {
		Service service = dao.listService(id);
		
		if (service == null)
			throw new ServiceException("El servicio con id =  " + id + " no existe.", "404");

		service.setActive(Constants.INACTIVE);
		return updateService(service);
	}

	/**
	 * M�todo para actualizar el servicio que se pasa por par�metro
	 * 
	 * @param service
	 * @return
	 * @throws ServiceException
	 */
	public String updateService(Service service) throws ServiceException {
		serviceValidator.validate(service);
		
		if(service.getActive() == null)
			service.setActive(Constants.ACTIVE);
		else if(service.getActive() != 0 && service.getActive() != 1)
			throw new ServiceException("El campo activo del servicio es inv�lido", "404");
		
		if(dao.listService(service.getId()) == null)
			throw new ServiceException("El servicio con ID " + service.getId() + " no est� registrado en el sistema", "404");
		
		Hotel hotel = hotelDao.getHotelOfService(service.getId());
		
		service.setHotel(hotel);
		return dao.updateService(service);
	}

	/**
	 * M�todo para obtener el servicio cuyo id se pasa por par�metro
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public Service listService(Long id) throws ServiceException {
		Service service = dao.listService(id);
		
		if(service == null)
			throw new ServiceException("El servicio con ID " + id + " no est� resgistrado en el sistema", "404");
		
		return service;
	}

	/**
	 * M�todo para obtener la lista de servicios de un hotel
	 * 
	 * @return
	 * @throws HotelException 
	 */
	public List<Service> listServicesOfHotel(Long hotelId) throws HotelException {
		if(hotelDao.listHotel(hotelId) == null)
			throw new HotelException("El hotel con ID " + hotelId + " no est� registrado en el sistema", "404");
		return dao.listServicesOfHotel(hotelId);
	}

	/**
	 * M�todo para obtener la lista de servicios de la reserva que se pasa por
	 * par�metro
	 * 
	 * @param bookingId
	 * @return
	 * @throws BookingException
	 */
	public List<Service> listServicesOfBooking(Long bookingId) throws BookingException {
		Booking b = bookingDao.listBooking(bookingId);
		
		if(b == null)
			throw new BookingException("La reserva con ID " + bookingId + " no est� registrada en el sistema", "404");
		
		return b.getServices().stream().collect(Collectors.toList());
	}

}
