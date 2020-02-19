package web.services;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import exception.HotelException;
import model.Hotel;
import model.Prueba;
import persistence.PruebaDAO;
import services.HotelService;

@WebService(endpointInterface = "web.services.IHotelWS")
public class HotelWS implements IHotelWS {

	private HotelService hotelService = new HotelService();

	@Override
	public String addHotel(Hotel hotel) throws HotelException, Exception {
		return hotelService.addHotel(hotel);
	}

	@Override
	public String deleteHotel(Long id) throws Exception {
		return hotelService.deleteHotel(id);
	}

	@Override
	public String updateHotel(Long id, Hotel hotel) throws HotelException, Exception {
		return hotelService.updateHotel(id, hotel);
	}

	@Override
	public Hotel listHotel(Long id) throws Exception {
		return hotelService.listHotel(id);
	}

	@Override
	public List<Hotel> listHotels() throws Exception {
		return hotelService.listHotels();
	}

	@Override
	public String savePrueba(Prueba p) throws SQLException {
		return new PruebaDAO(null).addPrueba(p);
	}

}
