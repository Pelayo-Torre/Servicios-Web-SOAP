package web.services;

import java.util.List;

import javax.jws.WebService;

import model.Service;
import services.ServiceService;
import utils.Constants;

@WebService(endpointInterface = "web.services.IServiceWS")
public class ServiceWS implements IServiceWS{

	ServiceService serviceService = new ServiceService();
	
	@Override
	public String add(Service service) {
		serviceService.add(service);
		return Constants.RESPONSE_OK;
	}

	@Override
	public String update(Service service) {
		serviceService.update(service);
		return Constants.RESPONSE_OK;
	}

	@Override
	public Service getService(Long id) {
		return serviceService.getService(id);
	}

	@Override
	public String delete(Long id) {
		serviceService.delete(id);
		return Constants.RESPONSE_OK;
	}

	@Override
	public List<Service> getServicesOfBooking(Long idBooking) {
		return serviceService.getServicesOfBooking(idBooking);
	}

	@Override
	public List<Service> getServicesOfHotel(Long idHotel) {
		return serviceService.getServicesOfHotel(idHotel);
	}

}
