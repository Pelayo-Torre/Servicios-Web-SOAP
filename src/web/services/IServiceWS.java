package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Service;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IServiceWS {
	
	@WebMethod
	public String add(Service service);
	
	@WebMethod
	public String update(Service service);
	
	@WebMethod
	public Service getService(Long id);
	
	@WebMethod
	public String delete(Long id);
	
	@WebMethod
	public List<Service> getServicesOfBooking(Long idBooking);
	
	@WebMethod
	public List<Service> getServicesOfHotel(Long idHotel);
	

}
