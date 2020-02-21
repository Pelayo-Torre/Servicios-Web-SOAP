package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.ServiceException;
import model.Service;
import services.ServiceService;

@WebService(endpointInterface = "web.services.IServiceWS")
public class ServiceWS implements IServiceWS {

	ServiceService serviceService = new ServiceService();

	@Override
	public String addService(Service service) throws ServiceException {
		return serviceService.addService(service);
	}

	@Override
	public String deleteService(Long id) throws ServiceException {
		return serviceService.deleteService(id);
	}

	@Override
	public String updateService(Long id, Service service) throws ServiceException {
		return serviceService.updateService(id, service);
	}

	@Override
	public Service listService(Long id) throws ServiceException {
		return serviceService.listService(id);
	}

	@Override
	public List<Service> listServicesOfHotel(Long hotelId) {
		return serviceService.listServicesOfHotel(hotelId);
	}

}
