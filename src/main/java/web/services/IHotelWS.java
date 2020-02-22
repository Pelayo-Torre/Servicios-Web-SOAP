package web.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.HotelException;
import model.Hotel;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IHotelWS {

	@WebMethod
	public Hotel listHotel(Long id) throws HotelException;

	@WebMethod
	public List<Hotel> listHotels() throws Exception;
}
