package web.services;

import java.util.List;

import javax.jws.WebService;

import exception.HotelException;
import model.Hotel;
import services.HotelService;

@WebService(endpointInterface = "web.services.IHotelWS")
public class HotelWS implements IHotelWS {

	private HotelService hotelService = new HotelService();

	@Override
	public Hotel listHotel(Long id) throws HotelException {
		return hotelService.listHotel(id);
	}

	@Override
	public List<Hotel> listHotels() throws Exception {
		return hotelService.listHotels();
	}

}
