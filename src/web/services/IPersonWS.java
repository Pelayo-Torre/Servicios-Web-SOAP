package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.PersonException;
import model.Client;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IPersonWS {
	
	@WebMethod
	public String add(Client person) throws PersonException;
	
	@WebMethod
	public void delete(Long id);
	
	@WebMethod
	public String update(Client person) throws PersonException;
	
	@WebMethod
	public void getPerson(Long id);
	
	@WebMethod
	public List<Client> getList();

}
