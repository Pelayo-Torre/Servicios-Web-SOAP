package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.HotelException;
import exception.ServiceException;
import model.Service;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IServiceWS {

	@WebMethod
	public String addService(Service service, Long hotelId) throws ServiceException, HotelException;

	@WebMethod
	public String deleteService(Long id) throws ServiceException;

	@WebMethod
	public String updateService(Long id, Service service) throws ServiceException;

	@WebMethod
	public Service listService(Long id) throws ServiceException;

	@WebMethod
	public List<Service> listServicesOfHotel(Long hotelId);

}
