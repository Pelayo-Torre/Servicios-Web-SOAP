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
		Service s = dao.findServiceByCode(service.getCode());
		if (s != null)
			throw new ServiceException("El servicio con c�digo =  " + service.getCode() + " ya existe en el sistema",
					"404");

		Hotel h = hotelDao.listHotel(hotelId);
		service.setHotel(h);
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
		return dao.deleteService(id);
	}

	/**
	 * M�todo para actualizar el servicio que se pasa por par�metro
	 * 
	 * @param service
	 * @return
	 * @throws ServiceException
	 */
	public String updateService(Long id, Service service) throws ServiceException {
		serviceValidator.validate(service);
		service.setId(id);
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
		return dao.listService(id);
	}

	/**
	 * M�todo para obtener la lista de servicios de un hotel
	 * 
	 * @return
	 */
	public List<Service> listServicesOfHotel(Long hotelId) {
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
		return b.getServices().stream().collect(Collectors.toList());
	}

}
