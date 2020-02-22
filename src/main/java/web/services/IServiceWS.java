package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.BookingException;
import exception.HotelException;
import exception.ServiceException;
import model.dtos.ServiceAddDTO;
import model.dtos.ServiceDTO;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IServiceWS {

	@WebMethod
	public String addService(ServiceAddDTO service) throws ServiceException, HotelException;

	@WebMethod
	public String deleteService(Long id) throws ServiceException;

	@WebMethod
	public String updateService(ServiceDTO service) throws ServiceException;

	@WebMethod
	public ServiceDTO listService(Long id) throws ServiceException;

	@WebMethod
	public List<ServiceDTO> listServicesOfHotel(Long hotelId) throws HotelException;
	
	@WebMethod
	public List<ServiceDTO> listServicesOfBooking(Long bookingId) throws BookingException;
	
}
