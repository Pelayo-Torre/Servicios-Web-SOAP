package web.services;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import exception.ServiceException;
import model.Service;
import services.ServiceService;

@WebService(endpointInterface = "web.services.IServiceWS")
public class ServiceWS implements IServiceWS {

	ServiceService serviceService = new ServiceService();

	@Override
	public String addService(Service service) throws ServiceException, SQLException {
		return serviceService.addService(service);
	}

	@Override
	public String deleteService(Long id) throws ServiceException, SQLException {
		return serviceService.deleteService(id);
	}

	@Override
	public String updateService(Long id, Service service) throws ServiceException, SQLException {
		return serviceService.updateService(id, service);
	}

	@Override
	public Service listService(Long id) throws SQLException {
		return serviceService.listService(id);
	}

	@Override
	public List<Service> listServicesOfHotel(Long hotelId) throws SQLException {
		return serviceService.listServicesOfHotel(hotelId);
	}

}
