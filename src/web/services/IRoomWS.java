package web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import modelo.Room;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IRoomWS {
	
	@WebMethod
	public String add(Room room);
	
	@WebMethod
	public String update(Room room);

	@WebMethod
	public Room getRoom(Long id);
	
	@WebMethod
	public String delete(Long id);
}
