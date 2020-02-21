package services;

import java.util.List;

import exception.HotelException;
import model.Hotel;
import persistence.HotelDAO;
import persistence.ManagerDAO;
import validators.HotelValidator;

public class HotelService {

	private HotelDAO dao = ManagerDAO.getInstance().getHotelDAO();
	private HotelValidator hotelValidator = new HotelValidator();

	/**
	 * Método para añadir un hotel
	 * 
	 * @param hotel
	 * @return
	 * @throws HotelException
	 */
	public String addHotel(Hotel hotel) throws HotelException {
		hotelValidator.validate(hotel);
		hotel.setLatitude(hotel.getLocation().getLatitude());
		hotel.setLongitude(hotel.getLocation().getLongitude());
		return dao.addHotel(hotel);
	}

	/**
	 * Método para borrar un hotel
	 * 
	 * @param id
	 * @return
	 * @throws HotelException
	 */
	public String deleteHotel(Long id) throws HotelException {
		return dao.deleteHotel(id);
	}

	/**
	 * Método para actualizar el hotel que se pasa por parámetro
	 * 
	 * @param hotel
	 * @return
	 * @throws HotelException
	 */
	public String updateHotel(Long id, Hotel hotel) throws HotelException {
		hotelValidator.validate(hotel);
		hotel.setId(id);
		hotel.setLatitude(hotel.getLocation().getLatitude());
		hotel.setLongitude(hotel.getLocation().getLongitude());
		return dao.updateHotel(hotel);
	}

	/**
	 * Método para obtener el hotel cuyo id se pasa por parámetro
	 * 
	 * @param id
	 * @return
	 * @throws HotelException
	 */
	public Hotel listHotel(Long id) throws HotelException {
		return dao.listHotel(id);
	}

	/**
	 * Método para obtener la lista de hoteles
	 * 
	 * @return
	 */
	public List<Hotel> listHotels() {
		return dao.listHotels();
	}

}
