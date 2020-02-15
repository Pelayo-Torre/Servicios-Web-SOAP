package web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.PersonException;
import modelo.Person;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IPersonWS {
	
	@WebMethod
	public String add(Person person) throws PersonException;
	
	@WebMethod
	public void delete(Long id);
	
	@WebMethod
	public String update(Person person) throws PersonException;
	
	@WebMethod
	public void getPerson(Long id);
	
	@WebMethod
	public Person [] getList();

}
