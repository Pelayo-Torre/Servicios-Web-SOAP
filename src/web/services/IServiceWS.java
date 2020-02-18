package web.services;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.ServiceException;
import model.Service;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IServiceWS {

	@WebMethod
	public String addService(Service service) throws ServiceException, SQLException;

	@WebMethod
	public String deleteService(Long id) throws ServiceException, SQLException;

	@WebMethod
	public String updateService(Long id, Service service) throws ServiceException, SQLException;

	@WebMethod
	public Service listService(Long id) throws SQLException;

	@WebMethod
	public List<Service> listServicesOfHotel(Long hotelId) throws SQLException;

}
