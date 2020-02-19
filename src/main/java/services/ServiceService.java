package services;

import java.sql.SQLException;
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
	 * @throws SQLException
	 * @throws ServiceException
	 */
	public String addService(Service service) throws SQLException, ServiceException {
		serviceValidator.validate(service);
		if (dao.existsService(service.getCode()))
			throw new ServiceException("El servicio que se añadir ya existe en el sistema", "404");
		return dao.addService(service);
	}

	/**
	 * Método para borrar un servicio
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ServiceException
	 */
	public String deleteService(Long id) throws SQLException, ServiceException {
		Service s = dao.listService(id);
		if (s == null)
			throw new ServiceException("El servicio que se desea eliminar no existe", "404");

		return dao.deleteService(id);
	}

	/**
	 * Método para actualizar el servicio que se pasa por parámetro
	 * 
	 * @param service
	 * @return
	 * @throws SQLException
	 */
	public String updateService(Long id, Service service) throws SQLException, ServiceException {
		serviceValidator.validate(service);
		Service s = dao.listService(id);
		if (s == null)
			throw new ServiceException("El servicio que se desea eliminar no existe", "404");
		service.setId(id);
		return dao.updateService(service);
	}

	/**
	 * Método para obtener el servicio cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Service listService(Long id) throws SQLException {
		return dao.listService(id);
	}

	/**
	 * Método para obtener la lista de servicios de un hotel
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Service> listServicesOfHotel(Long hotelId) throws SQLException {
		return dao.listServicesOfHotel(hotelId);
	}

}
