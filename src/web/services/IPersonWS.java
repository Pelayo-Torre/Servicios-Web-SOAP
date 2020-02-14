package web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import modelo.Person;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IPersonWS {
	
	@WebMethod
	public String add(String name, String surname, String mail, 
			String phone, int age);
	
	@WebMethod
	public void delete(Long id);
	
	@WebMethod
	public String update(Person p);
	
	@WebMethod
	public void getPerson(Long id);
	
	@WebMethod
	public Person [] getList();

}
