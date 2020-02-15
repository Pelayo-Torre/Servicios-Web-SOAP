package web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import modelo.Service;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IServicesWS {
	
	@WebMethod
	public String add(Service service);
	
	@WebMethod
	public String update(Service service);
	
	@WebMethod
	public Service getService(Long id);
	
	@WebMethod
	public String delete(Long id);

}