package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.BookingException;
import exception.HotelException;
import exception.ServiceException;
import model.dtos.DTOAssembler;
import model.dtos.ServiceAddDTO;
import model.dtos.ServiceDTO;
import services.ServiceService;

@WebService(endpointInterface = "web.services.IServiceWS")
public class ServiceWS implements IServiceWS {

	ServiceService serviceService = new ServiceService();

	@Override
	public String addService(ServiceAddDTO service) throws ServiceException, HotelException {
		return serviceService.addService(DTOAssembler.toEntity(service), service.getIdHotel());
	}

	@Override
	public String deleteService(Long id) throws ServiceException {
		return serviceService.deleteService(id);
	}

	@Override
	public String updateService(ServiceDTO dto) throws ServiceException {
		return serviceService.updateService(DTOAssembler.toEntity(dto));
	}

	@Override
	public ServiceDTO listService(Long id) throws ServiceException {
		return DTOAssembler.toDTO(serviceService.listService(id));
	}

	@Override
	public List<ServiceDTO> listServicesOfHotel(Long hotelId) throws HotelException {
		return DTOAssembler.toListDTOService(serviceService.listServicesOfHotel(hotelId));
	}

	@Override
	public List<ServiceDTO> listServicesOfBooking(Long bookingId) throws BookingException {
		return DTOAssembler.toListDTOService(serviceService.listServicesOfBooking(bookingId));
	}

}
