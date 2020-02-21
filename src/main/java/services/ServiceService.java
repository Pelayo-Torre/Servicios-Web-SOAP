package services;

import java.util.List;

import exception.ServiceException;
import model.Service;
import persistence.ManagerDAO;
import persistence.ServiceDAO;
import validators.ServiceValidator;

public class ServiceService {

	private ServiceDAO dao = ManagerDAO.getInstance().getServiceDAO();
	private ServiceValidator serviceValidator = new ServiceValidator();

	/**
	 * Método para añadir un servicio
	 * 
	 * @param service
	 * @return
	 * @throws ServiceException
	 */
	public String addService(Service service) throws ServiceException {
		serviceValidator.validate(service);
		Service s = dao.findServiceByCode(service.getCode());
		if (s == null)
			// TODO revisar codigo de error
			throw new ServiceException("El servicio con código =  " + service.getCode() + " ya existe en el sistema",
					"404");
		return dao.addService(service);
	}

	/**
	 * Método para borrar un servicio
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public String deleteService(Long id) throws ServiceException {
		return dao.deleteService(id);
	}

	/**
	 * Método para actualizar el servicio que se pasa por parámetro
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
	 * Método para obtener el servicio cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public Service listService(Long id) throws ServiceException {
		return dao.listService(id);
	}

	/**
	 * Método para obtener la lista de servicios de un hotel
	 * 
	 * @return
	 */
	public List<Service> listServicesOfHotel(Long hotelId) {
		return dao.listServicesOfHotel(hotelId);
	}

	/**
	 * Método para obtener la lista de servicios de la reserva que se pasa por
	 * parámetro
	 * 
	 * @param bookingId
	 * @return
	 */
	public List<Service> listServicesOfBooking(Long bookingId) {
		return dao.listServicesOfBooking(bookingId);
	}

}
