package web.services;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exception.HotelException;
import model.Hotel;
import model.Prueba;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IHotelWS {

	@WebMethod
	public String addHotel(Hotel hotel) throws HotelException, Exception;

	@WebMethod
	public String deleteHotel(Long id) throws Exception;

	@WebMethod
	public String updateHotel(Long id, Hotel hotel) throws HotelException, Exception;

	@WebMethod
	public Hotel listHotel(Long id) throws Exception;

	@WebMethod
	public List<Hotel> listHotels() throws Exception;

	@WebMethod
	public String savePrueba(Prueba p) throws SQLException;
}
